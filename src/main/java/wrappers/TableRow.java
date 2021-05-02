package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TableRow {

    private UIElement webElement;
    private List<RowCell> cellsList = new ArrayList();
    private WebDriver webDriver;
    private int cellsCount;

    public TableRow(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, by);
        //createCellsList();
    }

    public TableRow(WebDriver webDriver, WebElement webElement) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, webElement);
        //createCellsList();
    }

    private void createCellsList() {
        for(WebElement webElement: webElement.findElements(By.tagName("td"))) {
            cellsList.add(new RowCell(webDriver, webElement));
        }
    }

    public int getCellsCount() {
        return this.cellsCount;
    }

    public void setCellsCount(int cellsCount) {
        this.cellsCount = cellsCount;
    }
}
