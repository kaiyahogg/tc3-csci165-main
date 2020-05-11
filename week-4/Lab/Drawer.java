import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.*;
import java.io.*;



class Drawer extends JPanel {
    
    //creates a 9999x9999 array
    public static String fileName = "_9999x9999.";
    public static int[][] map = new int[rowSnatcher(fileName)][columnSnatcher(fileName)];

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer(String fileName) {
        initUI(fileName);
    }

    private void initUI(String fileName) {
        window.add(this);
        window.setTitle("Welcome to Hell");
        window.setSize(columnSnatcher(fileName), 20 + rowSnatcher(fileName));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g, map, rowSnatcher(fileName), columnSnatcher(fileName));
        indexOfLowestElevPath(g, map, fileName);
        System.out.println("\nWe hope you will enjoy your stay!");
    }


     //====================================================================================================
     
     

    public static int columnSnatcher(String fileName) {

        // Substring to extract size of column to be used in matrix
        String columnsString = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("x"));

        int columns = Integer.valueOf(columnsString);

        return columns;
    }

    public static int rowSnatcher(String fileName) {

        // Substring to extract size of row to be used in matrix
        String rowsString = fileName.substring(fileName.lastIndexOf("x") + 1, fileName.lastIndexOf("."));

        int rows = Integer.valueOf(rowsString);

        return rows;
    }

    public static void MapDataDrawer(int[][] matrix, String fileName, int rows, int columns) {

        // Try catch
        try {

            FileReader fr = new FileReader(fileName);
            Scanner sc = new Scanner(fr);

            // for loop that goes through the rows
            for (int i = 0; i < rows; i++) {

                // for loop that goes through the columns
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] += sc.nextInt();

                    // System.out.println(twoDimensional[i][j]);
                }
            }

            fr.close();
            sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static int findMin(int[][] matrix, int rows, int columns) {

        int min = matrix[0][0];

        // Nested for loop that finds the maximum number
        for (int i = 0; i < rows-1; i++) {

            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix, int rows, int columns) {
        int max = matrix[0][0];

        // Nested for loop that finds the maximum number
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    //Method that renders the map
    private void doDrawing(Graphics g, int[][] matrix, int rows, int columns) {

        /*
         * RGB Colors: ================================================ Black => (0, 0,
         * 0) => low elevation Mid Grey => (128, 128, 128) => mid elevation White =>
         * (255, 255, 255) => high elevation
         * 
         * Grey Scale colors are scaled in matching set of 3 numeric values
         */

        Graphics2D g2d = (Graphics2D) g;

        int x = 0, y = 0;
        
        int max = findMax(matrix, rows, columns);
        int min = findMin(matrix, rows, columns);
        int numerator = max - min;
        
        // figuring out how many values from matrix works with one unit of color values
        double divisorDouble = Math.round(numerator / 255);
        int divisor = (int) divisorDouble;
        Color grayscale;
        // nested for loop that iterates through the matrix
        for (int i = 0; i < columns; ++i) {

            y = 0;
            for (int j = 0; j < rows-1; ++j) {
                grayscale = new Color((matrix[j][i] - min) / (divisor+1), (matrix[j][i] - min) / (divisor+1), (matrix[j][i] - min) / (divisor+1));
                // assigning the color to be filled
                g2d.setColor(grayscale);

                // filling the rectangle with the assigned color
                g2d.fillRect(x, y, 1, 1);

                // increasing the y compnent by one
                y++;
                //System.out.println((matrix[j][i] - findMin(matrix, rows, columns)) / divisor);
            }

            // increasing the x component by one
            x++;
            //System.out.println(Math.round(((double) i / columns) * 100) + "%");
        }

        // Message that prints once the map has been drawn
        System.out.println("\n\nWelcome to Hell! Please follow the green for the easiest path to our only hotel. ");

    }

    //Method that finds the lowest value in a given column and in turn outputting the value for the row index
    //on where that minimum sits
    public static int indexOfMinRow(int[][] matrix, int rows, int column){
        
        int rowIndex = 0;
        for(int i = 0; i < rows; i++){
            if (matrix[rowIndex][column] > matrix[i][column]){
                rowIndex = i;
            }
            System.out.println(matrix[i][column]);
        }

        return rowIndex;
    }


    //Method that draws the lowest elevation path given a row, also returns the total change in elevation for the path
    public static int drawElevPath(Graphics g, int[][] matrix, int startRow, int rows, int columns){

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, startRow, 1, 1);
        int currentRow = startRow;
        int totalChange = matrix[startRow][0];

        //For loop that iterates through each column index
        for(int i = 1; i < columns; i++){
            
            //Establish fwd outside of if statements to work with else statement
            int fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
            
            //First set of if statements check to see if currentRow is at the top most index or bottom most index
            //and aglorithm advances accordingly
            if(currentRow > 0 && rows-2 > currentRow){
                fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdUp = Math.abs(matrix[currentRow][i-1] - matrix[currentRow-1][i]);
                int fwdDown = Math.abs(matrix[currentRow][i-1] - matrix[currentRow+1][i]);

                //Second set of if statements work to figure out what path is to be favored
                if (fwdUp < fwd && fwdUp < fwdDown){
                    
                    //Updating currentRow
                    currentRow = currentRow+1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    
                    //Adding the change between the old currentRow with currentRow to totalChange
                    totalChange += fwdUp;
                }
                
                else if (fwd < fwdUp && fwd < fwdDown){
                    
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwd;
                }

                else if (fwdDown < fwdUp && fwdDown < fwd){
                    
                    currentRow = currentRow-1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwdDown;
                }

                else if (fwdUp == fwdDown){
                    
                    //Defining/converting variables for 'coin flip'
                    int[] coinFlip = new int [2];
                    coinFlip[0] += fwdUp;
                    coinFlip[1] += fwdDown;
                    Double randomIndexDouble = Math.floor(Math.random()*2);
                    int randomIndex = randomIndexDouble.intValue();

                    //randomly picks between fwdUp or fwdDown
                    int random = coinFlip[randomIndex];

                    //If statement that controls the value of currentRow based on whether
                    //the random value is fwdUp or fwdDown
                    if (random == fwdUp){
                        currentRow = currentRow-1;
                        g2d.fillRect(i, currentRow, 1, 1);
                        totalChange += fwdUp;
                    }
                    
                    else if (random == fwdDown){
                        currentRow = currentRow+1;
                        g2d.fillRect(i, currentRow, 1, 1);
                        totalChange += fwdDown;
                    }
                    
                }
                
                else if(fwd == fwdUp || fwd == fwdDown){
                    g2d.drawRect(i, currentRow, 1, 1); 
                    totalChange += fwd;
                }    
            }

            else if (currentRow == 0){
                
                fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdDown = Math.abs(matrix[currentRow][i-1] - matrix[currentRow+1][i]);

                if (fwdDown < fwd){
                    
                    currentRow = currentRow+1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwdDown;
                }
                
                else if (fwd < fwdDown){
                    
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwd;
                }
            }

            else if(currentRow >= rows-5){
                //fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdUp = Math.abs(matrix[currentRow][i-1] - matrix[currentRow-1][i]);

                currentRow = currentRow-1;
                g2d.fillRect(i, currentRow, 1, 1);
                totalChange += fwdUp;
                
            }
            
        }

        //System.out.println(totalChange);
        //System.out.println(currentRow);
        //Returns totalChange
        return totalChange;

    }

    public static int drawLowestElevPath(Graphics g, int[][] matrix, int startRow, int rows, int columns){

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, startRow, 1, 1);
        int currentRow = startRow;
        int totalChange = matrix[startRow][0];

        //For loop that iterates through each column index
        for(int i = 1; i < columns; i++){
            
            //Establish fwd outside of if statements to work with else statement
            int fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
            
            //First set of if statements check to see if currentRow is at the top most index or bottom most index
            //and aglorithm advances accordingly
            if(currentRow > 0 && rows-2 > currentRow){
                fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdUp = Math.abs(matrix[currentRow][i-1] - matrix[currentRow-1][i]);
                int fwdDown = Math.abs(matrix[currentRow][i-1] - matrix[currentRow+1][i]);

                //Second set of if statements work to figure out what path is to be favored
                if (fwdUp < fwd && fwdUp < fwdDown){
                    
                    //Updating currentRow
                    currentRow = currentRow+1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    
                    //Adding the change between the old currentRow with currentRow to totalChange
                    totalChange += fwdUp;
                }
                
                else if (fwd < fwdUp && fwd < fwdDown){
                    
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwd;
                }

                else if (fwdDown < fwdUp && fwdDown < fwd){
                    
                    currentRow = currentRow-1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwdDown;
                }

                else if (fwdUp == fwdDown){
                    
                    //Defining/converting variables for 'coin flip'
                    int[] coinFlip = new int [2];
                    coinFlip[0] += fwdUp;
                    coinFlip[1] += fwdDown;
                    Double randomIndexDouble = Math.floor(Math.random()*2);
                    int randomIndex = randomIndexDouble.intValue();

                    //randomly picks between fwdUp or fwdDown
                    int random = coinFlip[randomIndex];

                    //If statement that controls the value of currentRow based on whether
                    //the random value is fwdUp or fwdDown
                    if (random == fwdUp){
                        currentRow = currentRow-1;
                        g2d.fillRect(i, currentRow, 1, 1);
                        totalChange += fwdUp;
                    }
                    
                    else if (random == fwdDown){
                        currentRow = currentRow+1;
                        g2d.fillRect(i, currentRow, 1, 1);
                        totalChange += fwdDown;
                    }
                    
                }
                
                else if(fwd == fwdUp || fwd == fwdDown){
                    g2d.drawRect(i, currentRow, 1, 1); 
                    totalChange += fwd;
                }    
            }

            else if (currentRow == 0){
                
                fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdDown = Math.abs(matrix[currentRow][i-1] - matrix[currentRow+1][i]);

                if (fwdDown < fwd){
                    
                    currentRow = currentRow+1;
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwdDown;
                }
                
                else if (fwd < fwdDown){
                    
                    g2d.fillRect(i, currentRow, 1, 1);
                    totalChange += fwd;
                }
            }

            else if(currentRow >= rows-5){
                //fwd = Math.abs(matrix[currentRow][i-1] - matrix[currentRow][i]);
                int fwdUp = Math.abs(matrix[currentRow][i-1] - matrix[currentRow-1][i]);

                currentRow = currentRow-1;
                g2d.fillRect(i, currentRow, 1, 1);
                totalChange += fwdUp;
                
            }
            
        }

        //System.out.println(totalChange);
        //System.out.println(currentRow);
        //Returns totalChange
        return totalChange;

    }

    
   
    //Method that finds the overrall lowest elevation path and returns the row it starts on
    public static int indexOfLowestElevPath(Graphics g, int[][] matrix, String fileName){
        
        int rows = rowSnatcher(fileName);
        int columns = columnSnatcher(fileName);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.BLUE);
        int minimumRowIndex = 0;

        for(int i = 0; i < rows; i++){
            //drawLowestElevPath(g, matrix, i, rows, columns);
            
            if (drawElevPath(g, matrix, minimumRowIndex, rows, columns) 
            > drawElevPath(g, matrix, i, rows, columns)){

                minimumRowIndex = i;
               
            }
        }

        drawLowestElevPath(g, matrix, minimumRowIndex, rows, columns);
        System.out.println("\nPath starts on row index of " + minimumRowIndex + " with a total elevation change of " + drawLowestElevPath(g, matrix, minimumRowIndex, rows, columns) + " meters.");

        return minimumRowIndex;
    }

    public static void main(String[] args) {

        //If statement that executes the rest of main if there is an argument
        if (args.length > 0) {
            fileName = args[0];
            
            //Setting methods as variables to make things more readable
            int rows = rowSnatcher(fileName)-1;
            int columns = columnSnatcher(fileName);
            

            MapDataDrawer(map, fileName, rows, columns);
            System.out.println("\n\nMaximum value: " + findMax(map, rows, columns));
            System.out.println("Minimum value: " + findMin(map, rows, columns));
            //System.out.println("Index of row that expreiences the minimum change in elevation: " + indexOfMinRow(map, rows, 7));
            
            


            EventQueue.invokeLater(() -> {
            
                Drawer ex = new Drawer(fileName);
                ex.setVisible(true);
            })

            
        }
        else System.out.println("No file name specified. Program is terminated.");
    } // end main
} // end class
