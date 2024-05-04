
public class Main {
    public static void main(String[] args) {
        Game g = new Game();

        boolean end = true;
        while (end){
            g.drawBoard();
            g.placeLetter();
            boolean isEnding = g.checkWin();
            if (isEnding){
                System.out.println("Game is ended");
                g.drawBoard();
                end = false;
            }
        }

    }
}
