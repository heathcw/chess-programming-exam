package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalculator {

    private ChessGame.TeamColor team;

    public KnightMovesCalculator(ChessGame.TeamColor team){
        this.team = team;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moveCollection = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPosition checkPosition = new ChessPosition(row + 2, col + 1);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row + 1, col + 2);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row - 1, col + 2);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row - 2, col + 1);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row - 2, col - 1);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row - 1, col - 2);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row + 1, col - 2);
        addMove(board, myPosition, checkPosition, moveCollection);

        checkPosition = new ChessPosition(row + 2, col - 1);
        addMove(board, myPosition, checkPosition, moveCollection);

        return moveCollection;
    }

    private void addMove(ChessBoard board, ChessPosition start, ChessPosition checkPosition, Collection<ChessMove> collection) {
        if (checkPosition.getRow() > 8 || checkPosition.getRow() < 1 || checkPosition.getColumn() > 8 || checkPosition.getColumn() < 1) {
            return;
        }

        if (board.getPiece(checkPosition) == null || board.getPiece(checkPosition).getTeamColor() != this.team) {
            collection.add(new ChessMove(start, checkPosition, null));
        }
    }
}
