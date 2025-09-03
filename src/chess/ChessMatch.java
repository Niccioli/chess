package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

import static chess.Color.BLACK;
import static chess.Color.WHITE;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        inicialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void inicialSetup(){
        placeNewPiece('b', '6', new Rook(board, WHITE));
        placeNewPiece('e', '8', new King(board, BLACK));
        placeNewPiece('e', '1', new King(board, WHITE));
    }
}
