package chess;

import java.util.ArrayList;
import java.util.Collection;

public class BishopMovesCalculator {

    private ChessGame.TeamColor team;

    public BishopMovesCalculator(ChessGame.TeamColor team){
        this.team = team;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moveCollection = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        boolean canAdd = true;

        while(canAdd && row < 8 && col > 1) {
            row++;
            col--;
            ChessPosition checkPosition = new ChessPosition(row, col);
            if (board.getPiece(checkPosition) == null) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != this.team) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
                break;
            } else {
                canAdd = false;
            }
        }

        row = myPosition.getRow();
        col = myPosition.getColumn();
        canAdd = true;

        while(canAdd && row < 8 && col < 8) {
            row++;
            col++;
            ChessPosition checkPosition = new ChessPosition(row, col);
            if (board.getPiece(checkPosition) == null) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != this.team) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
                break;
            } else {
                canAdd = false;
            }
        }

        row = myPosition.getRow();
        col = myPosition.getColumn();
        canAdd = true;

        while(canAdd && row > 1 && col < 8) {
            row--;
            col++;
            ChessPosition checkPosition = new ChessPosition(row, col);
            if (board.getPiece(checkPosition) == null) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != this.team) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
                break;
            } else {
                canAdd = false;
            }
        }

        row = myPosition.getRow();
        col = myPosition.getColumn();
        canAdd = true;

        while(canAdd && row > 1 && col > 1) {
            row--;
            col--;
            ChessPosition checkPosition = new ChessPosition(row, col);
            if (board.getPiece(checkPosition) == null) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != this.team) {
                moveCollection.add(new ChessMove(myPosition, checkPosition, null));
                break;
            } else {
                canAdd = false;
            }
        }

        return moveCollection;
    }
}
