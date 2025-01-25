package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalculator {

    private ChessGame.TeamColor team;

    public QueenMovesCalculator(ChessGame.TeamColor team){
        this.team = team;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moveCollection = new ArrayList<>();
        BishopMovesCalculator diagonalMoves = new BishopMovesCalculator(this.team);
        RookMovesCalculator horizontalMoves = new RookMovesCalculator(this.team);

        moveCollection = diagonalMoves.pieceMoves(board, myPosition);
        moveCollection.addAll(horizontalMoves.pieceMoves(board, myPosition));

        return moveCollection;
    }
}
