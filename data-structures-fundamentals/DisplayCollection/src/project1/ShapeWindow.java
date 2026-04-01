/**
 * 
 */
package project1;

import java.awt.Color;
import bag.BagInterface;
import cs2.TextShape;

import cs2.Window;
import cs2.Button;

import cs2.WindowSide;

/**
 * Interface Graphique
 */
public class ShapeWindow {

    // Fields private

    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;

    // Constructors public

    public ShapeWindow(BagInterface<String> bag) {

        itemBag = bag;
        window = new Window();
        window.setTitle("Project 1");

        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);

        quitButton = new Button("Quit");
        chooseButton = new Button("Choose");

        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(chooseButton, WindowSide.SOUTH);

        quitButton.onClick(this, "clickedQuit");
        chooseButton.onClick(this, "clickedChoose");

    }
    // Public Handlers


    public void clickedQuit(Button button) {

        System.exit(0);

    }


    public void clickedChoose(Button button) {

        if (!itemBag.isEmpty()) {

            String item = itemBag.remove();
            textShape.setText(item);

            colorText(item);
            centerText();
        }
        else {

            textShape.setText("No more items. ");
            textShape.setForegroundColor(Color.BLACK);
            centerText();

        }

    }


    private void colorText(String text) {
        if (text.contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (text.contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }

    }


    private void centerText() {
        int x = (window.getGraphPanelWidth() - textShape.getWidth()) / 2;
        int y = (window.getGraphPanelHeight() - textShape.getHeight()) / 2;

        textShape.moveTo(x, y);
    }

}
