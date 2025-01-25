package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalculator {

    private ChessGame.TeamColor team;

    public PawnMovesCalculator(ChessGame.TeamColor team){
        this.team = team;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moveCollection = new ArrayList<>();

        switch (this.team) {
            case WHITE:
                int row = myPosition.getRow();
                int col = myPosition.getColumn();
                ChessPosition checkPosition = new ChessPosition(row + 1, col);
                if (myPosition.getRow() == 2 && board.getPiece(checkPosition) == null) {
                    checkPosition = new ChessPosition(row + 2, col);
                    normalMove(board, myPosition, checkPosition, moveCollection, 8);
                }
                checkPosition = new ChessPosition(row + 1, col);
                normalMove(board, myPosition, checkPosition, moveCollection, 8);

                checkPosition = new ChessPosition(row + 1, col + 1);
                captureMove(board, myPosition, checkPosition, moveCollection, 8);

                checkPosition = new ChessPosition(row + 1, col - 1);
                captureMove(board, myPosition, checkPosition, moveCollection, 8);
                break;

            case BLACK:
                row = myPosition.getRow();
                col = myPosition.getColumn();
                checkPosition = new ChessPosition(row - 1, col);
                if (myPosition.getRow() == 7 && board.getPiece(checkPosition) == null) {
                    checkPosition = new ChessPosition(row - 2, col);
                    normalMove(board, myPosition, checkPosition, moveCollection, 1);
                }
                checkPosition = new ChessPosition(row - 1, col);
                normalMove(board, myPosition, checkPosition, moveCollection, 1);

                checkPosition = new ChessPosition(row - 1, col + 1);
                captureMove(board, myPosition, checkPosition, moveCollection, 1);

                checkPosition = new ChessPosition(row - 1, col - 1);
                captureMove(board, myPosition, checkPosition, moveCollection, 1);
                break;
        }

        return moveCollection;
    }

    private void normalMove(ChessBoard board, ChessPosition start, ChessPosition checkPosition, Collection<ChessMove> collection, int end) {
        if (checkPosition.getRow() > 8 || checkPosition.getRow() < 1 || checkPosition.getColumn() > 8 || checkPosition.getColumn() < 1) {
            return;
        }

        if (board.getPiece(checkPosition) == null) {
            if (checkPosition.getRow() == end) {
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.QUEEN));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.ROOK));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.BISHOP));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.KNIGHT));
            } else {
                collection.add(new ChessMove(start, checkPosition, null));
            }
        }
    }

    private void captureMove(ChessBoard board, ChessPosition start, ChessPosition checkPosition, Collection<ChessMove> collection, int end) {
        if (checkPosition.getRow() > 8 || checkPosition.getRow() < 1 || checkPosition.getColumn() > 8 || checkPosition.getColumn() < 1) {
            return;
        }

        if (board.getPiece(checkPosition) != null && board.getPiece(checkPosition).getTeamColor() != this.team) {
            if (checkPosition.getRow() == end) {
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.QUEEN));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.ROOK));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.BISHOP));
                collection.add(new ChessMove(start, checkPosition, ChessPiece.PieceType.KNIGHT));
            } else {
                collection.add(new ChessMove(start, checkPosition, null));
            }
        }
    }
}
