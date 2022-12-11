public class MissingTile {
    public static void tileGrid(Grid board) {
        tilingHelper(board.size(),0,0,board.getPaintedCellX(), board.getPaintedCellY(), board);
    }

    static void tilingHelper(int size, int topX, int topY,
                             int paintedX, int paintedY, Grid bd) {
        if (size == 2) {
            int basex = paintedX - topX;
            int basey = paintedY - topY;
            //TL
            if (basex == 0 & basey == 0) {
                bd.setTile(paintedX, paintedY, 3);

            }
            //TR
            else if (basex == 1 & basey == 0) {
                bd.setTile(paintedX, paintedY, 0);
            }
            //BL
            else if (basex == 0 && basey == 1) {
                bd.setTile(paintedX, paintedY, 2);
            }
            //BR
            else if (basex == 1 & basey == 1) {
                bd.setTile(paintedX, paintedY, 1);
            }
        } else {
            String quad = PaintedCellQuadrant(bd, paintedX - topX, paintedY - topY, size);
            switch (quad) {
                case "TopLeft":
                    bd.setTile(topX + (size / 2) - 1, topY + (size / 2) - 1, 3);
                    tilingHelper(size / 2, topX, topY, paintedX, paintedY, bd);
                    tilingHelper(size / 2, topX + size / 2, topY, topX + size / 2, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX, topY + size / 2, topX + size / 2 - 1, topY + size / 2, bd);
                    tilingHelper(size / 2, topX + size / 2, topY + size / 2, topX + size / 2, topY + size / 2, bd);
                    break;
                case "TopRight":
                    bd.setTile(topX + size / 2, topY + (size / 2) - 1, 0);
                    tilingHelper(size / 2, topX, topY, topX + size / 2 - 1, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX + size / 2, topY, paintedX, paintedY, bd);
                    tilingHelper(size / 2, topX, topY + size / 2, topX + size / 2 - 1, topY + size / 2, bd);
                    tilingHelper(size / 2, topX + size / 2, topY + size / 2, topX + size / 2, topY + size / 2, bd);
                    break;
                case "BottomLeft":
                    bd.setTile(topX + (size / 2) - 1, topY + size / 2, 2);
                    tilingHelper(size / 2, topX, topY, topX + size / 2 - 1, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX + size / 2, topY, topX + size / 2, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX, topY + size / 2, paintedX, paintedY, bd);
                    tilingHelper(size / 2, topX + size / 2, topY + size / 2, topX + size / 2, topY + size / 2, bd);
                    break;
                case "BottomRight":
                    bd.setTile(topX + size / 2, topY + size / 2, 1);
                    tilingHelper(size / 2, topX, topY, topX + size / 2 - 1, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX + size / 2, topY, topX + size / 2, topY + size / 2 - 1, bd);
                    tilingHelper(size / 2, topX, topY + size / 2, topX + size / 2 - 1, topY + size / 2, bd);
                    tilingHelper(size / 2, topX + size / 2, topY + size / 2, paintedX, paintedY, bd);
                    break;

            }
        }
    }

    public static String PaintedCellQuadrant(Grid board, int paintedX, int paintedY, int size) {
        if (size / 2 <= paintedX && paintedX <= size - 1 && 0 <= paintedY && paintedY <= (size / 2) - 1) {
            return "TopRight";
        } else if (0 <= paintedX && paintedX <= (size - 2) - 1 && 0 <= paintedY && paintedY <= (size / 2) - 1) {
            return "TopLeft";
        } else if (0 <= paintedX && paintedX <= (size / 2) - 1 && size / 2 <= paintedY && paintedY <= size - 1) {
            return "BottomLeft";
        } else if (size / 2 <= paintedX && paintedX <= size - 1 && size / 2 <= paintedY && paintedY <= size - 1) {
            return "BottomRight";
        }
        return "";
    }
}
