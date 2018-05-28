package tuke.robo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Diplomovka {
    private JPanel panelMain;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JLabel maticaAHorneLabel;
    private JTable matrixLower;
    private JTable matrixUpper;
    private JLabel maticaADolneLabel;
    private JButton vypocitajButton;
    private JTable vectorLower;
    private JTable vectorUpper;
    private JTable table5;
    private JLabel results;
    private JTable table1;
    private JTable acirk;
    private JTable bcirk;
    private JButton binarnyVypocetButton;
    private JTabbedPane tabbedPane1;
    private JTable table2;
    private JFormattedTextField formattedTextField3;
    private JTable matrixA;
    private JTable matrixB;
    private JButton vypocitajButton2;
    private JTable vektorX;
    private JTable table3;
    private JLabel nazov;
    private JLabel vstup;
    private JLabel results2;
    private JLabel cirkul;
    private JLabel vstup2;
    private JLabel results3;
    private JLabel cirkul2;
    private JLabel vstup3;
    private JLabel results4;
    private JTable vektorX2;

    private ArrayList<Integer> lowerMatrix;
    private ArrayList<Integer> upperMatrix;
    private ArrayList<Integer> lowerVector;
    private ArrayList<Integer> upperVector;

    private ArrayList<ArrayList<Integer>> vectors;

    private int size;
    private int possiblyResultRow;
    private int universallyResultRow;


    public Diplomovka() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);

        nazov.setFont(new Font("Serif", Font.BOLD, 24));
        cirkul.setFont(new Font("Serif", Font.BOLD, 24));
        cirkul2.setFont(new Font("Serif", Font.BOLD, 24));
        vstup.setFont(new Font("Serif", Font.BOLD, 16));
        vstup2.setFont(new Font("Serif", Font.BOLD, 16));
        vstup3.setFont(new Font("Serif", Font.BOLD, 16));
        results.setFont(new Font("Serif", Font.BOLD, 18));
        results2.setFont(new Font("Serif", Font.BOLD, 18));
        results3.setFont(new Font("Serif", Font.BOLD, 18));
        results4.setFont(new Font("Serif", Font.BOLD, 18));
        results.setForeground(Color.red);
        results2.setForeground(Color.red);
        results3.setForeground(Color.red);
        results4.setForeground(Color.red);

        final DefaultTableModel upperMatrixModel = new DefaultTableModel(1,1);
        final DefaultTableModel lowerMatrixModel = new DefaultTableModel(1,1);
        final DefaultTableModel vectorLowerModel = new DefaultTableModel(1,1);
        final DefaultTableModel vectorUpperModel = new DefaultTableModel(1,1);
        final DefaultTableModel possibleResultModel = new DefaultTableModel(1,1);
        final DefaultTableModel universallyResultModel = new DefaultTableModel(1,1);

        final DefaultTableModel acirkModel = new DefaultTableModel(1,1);
        final DefaultTableModel bcirkModel = new DefaultTableModel(1,1);
        final DefaultTableModel secondTabResultModel = new DefaultTableModel(1,1);

        final DefaultTableModel matrixAModel = new DefaultTableModel(1,1);
        final DefaultTableModel matrixBModel = new DefaultTableModel(1,1);
        final DefaultTableModel vektorXModel = new DefaultTableModel(1,1);
        final DefaultTableModel vektorX2Model = new DefaultTableModel(1,1);
        final DefaultTableModel threeTabResultModel = new DefaultTableModel(1,1);

        formattedTextField1.setFormatterFactory(factory);
        formattedTextField2.setFormatterFactory(factory);
        formattedTextField3.setFormatterFactory(factory);
        formattedTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                maticaAHorneLabel.setVisible(true);
                maticaADolneLabel.setVisible(true);
                results.setVisible(true);
                size = Integer.parseInt(formattedTextField1.getText());
                matrixLower.setVisible(true);
                matrixUpper.setVisible(true);
                vectorLower.setVisible(true);
                vectorUpper.setVisible(true);
                table5.setVisible(true);

                lowerMatrix = new ArrayList<>();
                upperMatrix = new ArrayList<>();
                lowerVector = new ArrayList<>();
                upperVector = new ArrayList<>();
                vectors = new ArrayList<>();

                upperMatrixModel.setColumnCount(0);
                lowerMatrixModel.setColumnCount(0);
                vectorLowerModel.setRowCount(0);
                vectorUpperModel.setRowCount(0);
                possibleResultModel.setRowCount(0);
                universallyResultModel.setRowCount(0);

                upperMatrixModel.setColumnCount(size);
                lowerMatrixModel.setColumnCount(size);
                vectorLowerModel.setRowCount(size);
                vectorUpperModel.setRowCount(size);
                possibleResultModel.setRowCount(11 + 3 * size);
                universallyResultModel.setRowCount(17 * size - 6);

                matrixLower.setModel(upperMatrixModel);
                matrixUpper.setModel(lowerMatrixModel);
                vectorLower.setModel(vectorLowerModel);
                vectorUpper.setModel(vectorUpperModel);
                table5.setModel(possibleResultModel);
                table1.setModel(universallyResultModel);

                possiblyResultRow = 0;
                universallyResultRow = 0;
            }
        });

        formattedTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                size = Integer.parseInt(formattedTextField2.getText());

                acirkModel.setColumnCount(0);
                bcirkModel.setColumnCount(0);

                secondTabResultModel.setRowCount(0);

                acirkModel.setColumnCount(size);
                bcirkModel.setColumnCount(size);

                acirk.setModel(acirkModel);
                bcirk.setModel(bcirkModel);

                secondTabResultModel.setRowCount(5);
                table2.setModel(secondTabResultModel);
            }
        });

        formattedTextField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                size = Integer.parseInt(formattedTextField3.getText());

                matrixAModel.setColumnCount(0);
                matrixBModel.setColumnCount(0);
                vektorXModel.setColumnCount(0);
                vektorX2Model.setColumnCount(0);

                threeTabResultModel.setRowCount(0);

                matrixAModel.setColumnCount(size);
                matrixAModel.setRowCount(size);
                matrixBModel.setColumnCount(size);
                matrixBModel.setRowCount(size);

                vektorXModel.setColumnCount(size);
                vektorX2Model.setColumnCount(size);

                matrixA.setModel(matrixAModel);
                matrixB.setModel(matrixBModel);
                vektorX.setModel(vektorXModel);
                vektorX2.setModel(vektorX2Model);

                threeTabResultModel.setRowCount(5);
                table3.setModel(threeTabResultModel);
            }
        });

        vypocitajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VypocitajClicked(e);
            }
        });

        binarnyVypocetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BinaryClicked(e);
            }
        });

        vypocitajButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GavalecClicked(e);
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Diplomovka().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void VypocitajClicked(ActionEvent e) {
        // Nacitanie udajov z tabulky a vlozenie do arraylistov
        for (int i = 0; i < size; i++) {
            lowerMatrix.add(Integer.parseInt(matrixLower.getValueAt(0, i).toString()));
            upperMatrix.add(Integer.parseInt(matrixUpper.getValueAt(0, i).toString()));
            lowerVector.add(Integer.parseInt(vectorLower.getValueAt(i, 0).toString()));
            upperVector.add(Integer.parseInt(vectorUpper.getValueAt(i, 0).toString()));
        }
        addResult("Vypočítané bázické vektory:", 0);
        vectors = this.createVectorI(lowerVector, upperVector);

        possibleCalc();
        universallyCalc();
    }

    private void BinaryClicked(ActionEvent e) {
        ArrayList<Integer> matrixA = new ArrayList<>();
        ArrayList<Integer> matrixB = new ArrayList<>();
        // Nacitanie udajov z tabulky a vlozenie do arraylistov
        for (int i = 0; i < size; i++) {
            matrixA.add(Integer.parseInt(acirk.getValueAt(0, i).toString()));
            matrixB.add(Integer.parseInt(bcirk.getValueAt(0, i).toString()));
        }

        ArrayList<ArrayList<Integer>> circulantMatrixA = this.createCirculantMatrix(matrixA);
        ArrayList<ArrayList<Integer>> circulantMatrixB = this.createCirculantMatrix(matrixB);

        int pocetNulA = 0;
        int pocetNulB = 0;

        for (int i = 0; i < size; i++) {

            if (matrixA.get(i) == 0) {
                pocetNulA++;
            }

            if (matrixB.get(i) == 0) {
                pocetNulB++;
            }
        }

        if ((pocetNulA == (size) || pocetNulB == (size)) && pocetNulA != pocetNulB) {
            table2.setValueAt("Pre danu rovnicu A ⊗ x = B ⊗ x sa nepodarilo najst vektor, teda rovnica nema riesenie ", 0, 0);
            return;
        }

        int pocetNul = Math.max(pocetNulA, pocetNulB);

        ArrayList<Integer> vectorX = new ArrayList<>();

        String output = "x = (";
        for (int i = 0; i < size; i++) {
            if (i < pocetNul + 1) {
                vectorX.add(1);
                output +=  "1 ";
            } else {
                vectorX.add(0);
                output += "0 ";
            }
        }

        table2.setValueAt("Riešením rovnice A ⊗ x = B ⊗ x je vektor v tvare ", 0, 0);
        table2.setValueAt(output.substring(0, output.length() - 1) + ")T", 1, 0);

        ArrayList<ArrayList<Integer>> vectorA, vectorB;
        vectorA = this.createVerifyVector(vectorX, circulantMatrixA, 1);
        vectorB = this.createVerifyVector(vectorX, circulantMatrixB, 1);

        String outputA = "(";
        String outputB = "(";
        for (int i = 0; i < size; i++) {
            outputA += vectorA.get(i).get(0) + " ";
            outputB += vectorB.get(i).get(0) + " ";
        }

        table2.setValueAt("Overime ci dany vektor vyhovuje rovnici", 3, 0);
        table2.setValueAt(outputA.substring(0, outputA.length() - 1) + ")T = " +
                outputB.substring(0, outputB.length() - 1) + ")T",
                4, 0
        );
    }

    private void GavalecClicked(ActionEvent e) {
        ArrayList<ArrayList<Integer>> maticaA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> maticaB = new ArrayList<>();
        ArrayList<Integer> vectorX = new ArrayList<>();
        ArrayList<Integer> vectorX2 = new ArrayList<>();

        // Nacitanie udajov z tabulky a vlozenie do arraylistov
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> rowA = new ArrayList<>();
            ArrayList<Integer> rowB = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                rowA.add(Integer.parseInt(matrixA.getValueAt(i, j).toString()));
                rowB.add(Integer.parseInt(matrixB.getValueAt(i, j).toString()));
            }

            maticaA.add(rowA);
            maticaB.add(rowB);

            vectorX.add(Integer.parseInt(vektorX.getValueAt(0,i).toString()));
            vectorX2.add(Integer.parseInt(vektorX2.getValueAt(0,i).toString()));
        }

        // KROK 2 - Mnozina M
        ArrayList<Integer> resultsA = new ArrayList<>();
        ArrayList<Integer> resultsB = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultsA.add(findMaxGavalec(maticaA.get(i), vectorX));
            resultsB.add(findMaxGavalec(maticaB.get(i), vectorX));
        }

        boolean foundX = true;
        for (int i = 0; i < size; i++) {
            int numberA = resultsA.get(i);
            int numberB = resultsB.get(i);

            if (numberA < numberB) {
                foundX = false;
            } else if (numberA > numberB) {
                for (int j = 0; j < size; j++) {
                    int number = maticaA.get(i).get(j);
                    maticaA.get(i).set(j, maticaB.get(i).get(j));
                    maticaB.get(i).set(j, number);
                }
                foundX = false;
            }
        }

        if (foundX) {
            String output = "x = (";
            for (int i = 0; i < size; i++) {
                int number = vectorX.get(i);

                if (number == 0) {
                    output += "-∞ ";
                } else {
                    output += "∞ ";
                }
            }
            table3.setValueAt(output.substring(0, output.length() - 1) + ")T", 0, 0);
            return;
        }

        vectorX = getVectorX(maticaA, maticaB, vectorX);

        String output = "x = (";
        for (int i = 0; i < size; i++) {
            int number = vectorX.get(i);

            if (number == 0) {
                output += "-∞ ";
            } else {
                output += "∞ ";
            }
        }
        table3.setValueAt(output.substring(0, output.length() - 1) + ")T", 1, 0);

        if (this.compareVectors(vectorX, vectorX2)) {
            table3.setValueAt("Vektor x je riesenim rovnice A ⊗ x = B ⊗ x pre všeobecné binárne matice v max-plus algebre.", 2, 0);
        } else {
            table3.setValueAt("Pre dané matice a intervalový vektor sa nepodarilo nájsť vektor pre rovnicu A ⊗ x = B ⊗ x.", 2, 0);
        }
    }

    private void addResult(String text, int table){
        if (table == 0) {
            table5.setValueAt(text, possiblyResultRow, 0);
            possiblyResultRow++;
        } else if (table == 1) {
            table1.setValueAt(text, universallyResultRow, 0);
            universallyResultRow++;
        }
    }

    private void possibleCalc() {
        int lambda = this.findMax(lowerMatrix);
        addResult("Vypočítaná lambda:", 0);
        addResult("λ(A) = " + lambda, 0);

        ArrayList<Integer> caret = this.calculateOneRowOfCirculantMatrix(upperMatrix, lambda);
        String caretOutput = "A^ = (";
        for (Integer number : caret) {
            caretOutput += number + " ";
        }
        addResult("", 0);
        addResult("Vypočítaná matica A^:", 0);
        addResult(caretOutput.substring(0, caretOutput.length() - 1) + ")", 0);
        addResult("", 0);

        ArrayList<ArrayList<Integer>> circulantMatrix = this.createCirculantMatrix(caret);

        ArrayList<ArrayList<Integer>> powerMatrix = new ArrayList<>(circulantMatrix);
        // mocnina A caret
        for (int i = 0; i < size * size - 1; i++) {
            powerMatrix = this.createMultiplicationMatrix(powerMatrix, circulantMatrix, size);
        }

        ArrayList<ArrayList<Integer>> powerMatrixPlusOne = new ArrayList<>(powerMatrix);
        powerMatrixPlusOne = this.createMultiplicationMatrix(powerMatrixPlusOne, circulantMatrix, size);

        addResult("Overenie, či jednotlivé bázické vektory sú z attr(A^):", 0);
        checkAttractionSet(lambda, vectors, powerMatrix, powerMatrixPlusOne, 0);
    }

    private void universallyCalc() {
        ArrayList<ArrayList<Integer>> matrixI = new ArrayList<>();
        ArrayList<Integer> lambdas = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> circullantMatrixI = new ArrayList<>();

        addResult("Vypočítané bázické matice:", 1);
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> oneRow = new ArrayList<>(lowerMatrix);
            oneRow.set(i, upperMatrix.get(i));

            matrixI.add(oneRow);
            lambdas.add(findMax(oneRow));
            circullantMatrixI.add(this.createCirculantMatrix(oneRow));
            String output = "A(" + (i + 1) + ") = (";
            for (int j = 0; j < size; j++) {
                output += circullantMatrixI.get(i).get(0).get(j) + " ";
            }
            addResult(output.substring(0, output.length() - 1) + ")", 1);
        }
        addResult("", 1);

        addResult("Vypočítané lambdy:", 1);
        for (int i = 0; i < size; i++) {
            addResult("λ(A(" + (i + 1) + ")) = " + lambdas.get(i), 1);
        }
        addResult("", 1);

        boolean isRobust = true;
        for (int i = 0; i < size; i++) {
            ArrayList<ArrayList<Integer>> circulantMatrix = circullantMatrixI.get(i);
            ArrayList<ArrayList<Integer>> powerMatrix = new ArrayList<>(circulantMatrix);

            for (int j = 0; j < size * size - 1; j++) {
                powerMatrix = this.createMultiplicationMatrix(powerMatrix, circulantMatrix, size);
            }

            ArrayList<ArrayList<Integer>> powerMatrixPlusOne = new ArrayList<>(powerMatrix);
            powerMatrixPlusOne = this.createMultiplicationMatrix(powerMatrixPlusOne, circulantMatrix, size);

            addResult("Iterácia pre A(" + (i+1) + "):", 1);
            if(!checkAttractionSet(lambdas.get(i), vectors, powerMatrix, powerMatrixPlusOne, 1)) {
                isRobust = false;
            }
        }

        addResult("", 1);
        if(isRobust) {
            addResult("Daná intervalová cirkulantná matica A je univerzálne X-robustná!", 1);
        } else {
            addResult("Daná intervalová cirkulantná matica A nie je univerzálne X-robustná!", 1);
        }
    }

    private int findMax(ArrayList<Integer> input) {
        int max = Integer.MIN_VALUE;

        for(Integer current : input) {
            if (max < current) {
                max = current;
            }
        }

        return max;
    }

    private ArrayList<Integer> calculateOneRowOfCirculantMatrix(ArrayList<Integer> input, int max) {
        ArrayList<Integer> row = new ArrayList<>();

        for(Integer current : input) {
            if (max > current) {
                row.add(current);
            } else {
                row.add(max);
            }
        }

        return row;
    }

    private ArrayList<ArrayList<Integer>> createCirculantMatrix(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> circulantMatrix = new ArrayList<>();

        ArrayList<Integer> copy = new ArrayList<>(input);
        circulantMatrix.add(copy);

        for (int i = 0; i < input.size() - 1; i++) {
            Collections.rotate(input, 1);
            copy = new ArrayList<>(input);
            circulantMatrix.add(copy);
        }

        return circulantMatrix;
    }

    private ArrayList<ArrayList<Integer>> createVectorI(ArrayList<Integer> upper, ArrayList<Integer> lower) {
        ArrayList<ArrayList<Integer>> vectors = new ArrayList<>();

        for (int i  = 0; i < lower.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>(upper);
            copy.set(i, lower.get(i));
            vectors.add(copy);

            String vectorOutput = "x(" + (i + 1) + ") = (";
            for (Integer number : copy) {
                vectorOutput += number + " ";
            }
            addResult(vectorOutput.substring(0, vectorOutput.length() - 1) + ")T", 0);
        }
        addResult("", 0);

        return vectors;
    }

    private ArrayList<ArrayList<Integer>> createMultiplicationMatrix(ArrayList<ArrayList<Integer>> originalMatrix, ArrayList<ArrayList<Integer>> biggerMatrix, int size) {
        ArrayList<ArrayList<Integer>> attractionMatrix = new ArrayList<>();
        int numbersOfRows = biggerMatrix.size();

        for (int j = 0; j < numbersOfRows; j++) { // riadky a = stlpce a = riadky b
            ArrayList<Integer> multiplications = new ArrayList<>();
            for (int i = 0; i < size; i++) { // stlpce v b
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < numbersOfRows; k++) { // riadky a = stlpce a = riadky b
                    int cislo1 = originalMatrix.get(k).get(i);
                    int cislo2 = biggerMatrix.get(j).get(k);
                    int resultOfSingleMultiple = cislo1 + cislo2;
                    if (resultOfSingleMultiple > max) {
                        max = resultOfSingleMultiple;
                    }
                }
                multiplications.add(max);
            }

            attractionMatrix.add(multiplications);
        }

        return attractionMatrix;
    }

    private ArrayList<ArrayList<Integer>> createVerifyVector(ArrayList<Integer> vector, ArrayList<ArrayList<Integer>> matrix, int size) {
        ArrayList<ArrayList<Integer>> enterMatrix = new ArrayList<>();
        for (Integer number: vector) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(number);
            enterMatrix.add(row);
        }

        matrix = this.createMultiplicationMatrix(enterMatrix, matrix, size);

        return matrix;
    }

    private boolean checkAttractionSet(int lambda, ArrayList<ArrayList<Integer>> vectors, ArrayList<ArrayList<Integer>> powerMatrix, ArrayList<ArrayList<Integer>> powerMatrixPlusOne, int table){
        ArrayList<ArrayList<Integer>> vector;

        boolean isRobust = true;

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> rightSide = new ArrayList<>();
            ArrayList<Integer> leftSide = new ArrayList<>();

            String attractionOutput = "Iterácia pre x(" + (i + 1) + "):";
            addResult(attractionOutput, table);

            vector = this.createVerifyVector(vectors.get(i), powerMatrix, 1);
            for (ArrayList<Integer> row : vector) {
                rightSide.add(row.get(0) + lambda);
            }
            vector = this.createVerifyVector(vectors.get(i), powerMatrixPlusOne, 1);

            attractionOutput = "(";
            for (ArrayList<Integer> row : vector) {
                leftSide.add(row.get(0));
                attractionOutput += row.get(0) + " ";
            }
            attractionOutput = attractionOutput.substring(0, attractionOutput.length() - 1) + ")T = (";

            for (Integer number : rightSide) {
                attractionOutput += number + " ";
            }
            addResult(attractionOutput.substring(0, attractionOutput.length() - 1) + ")T", table);


            if(!isPossiblyRobust(leftSide, rightSide)) {
                isRobust = false;
            }
        }

        addResult("", table);
        if(table == 0) {
            if(isRobust) {
                addResult("Daná intervalová cirkulantná matica A je možne X-robustná!", table);
            } else {
                addResult("Daná intervalová cirkulantná matica A nie je možne X-robustná!", table);
            }
        }

        return isRobust;
    }

    private boolean isPossiblyRobust(ArrayList<Integer> leftSide, ArrayList<Integer> rightSide) {
       for (int i = 0; i < leftSide.size(); i++) {
            int left = leftSide.get(i);
            int right = rightSide.get(i);

            if (left != right) {
                return false;
            }
        }

        return true;
    }

    // odtial Gavalec

    private int findMaxGavalec(ArrayList<Integer> matrixRow, ArrayList<Integer> vectorX) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrixRow.size(); i++) {
            int vectorNumber = vectorX.get(i);
            int matrixRowNumber = matrixRow.get(i);

            int current = vectorNumber < matrixRowNumber ? vectorNumber : matrixRowNumber;

            if (max < current) {
                max = current;
            }
        }

        return max;
    }

    private boolean compareVectors(ArrayList<Integer> vectorX, ArrayList<Integer> vectorX2) {
       for (int i = 0; i < vectorX.size(); i++) {
            int left = vectorX2.get(i);
            int right = vectorX.get(i);

            if (left > right) {
                return false;
            }
        }

        return true;
    }

    private ArrayList<Integer> getVectorX(ArrayList<ArrayList<Integer>> maticaA, ArrayList<ArrayList<Integer>> maticaB, ArrayList<Integer> vectorX) {
        // KROK 3
        ArrayList<Integer> resultsA = new ArrayList<>();
        ArrayList<Integer> resultsB = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultsA.add(findMaxGavalec(maticaA.get(i), vectorX));
            resultsB.add(findMaxGavalec(maticaB.get(i), vectorX));
        }

        // KROK 4
        ArrayList<Integer> mnozinaIMensia = new ArrayList<>();
        ArrayList<Integer> mnozinaIRovna = new ArrayList<>();

        int alpha = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int numberA = resultsA.get(i);
            int numberB = resultsB.get(i);

            if (numberA < numberB) {
                if( numberA < alpha) {
                    alpha = numberA;
                }

                mnozinaIMensia.add(i);
            }

            if (numberA == numberB) {
                mnozinaIRovna.add(i);
            }
        }

        ArrayList<Integer> mnozinaIMensiaAlpha = new ArrayList<>();
        for (Integer indexI : mnozinaIMensia) {
            if (resultsA.get(indexI) == alpha) {
                mnozinaIMensiaAlpha.add(indexI);
            }
        }

        ArrayList<Integer> mnozinaIRovnaAlpha = new ArrayList<>();
        for (Integer indexI : mnozinaIRovna) {
            if (resultsA.get(indexI) <= alpha) {
                mnozinaIRovnaAlpha.add(indexI);
            }
        }

        ArrayList<Integer> mnozinaJ = new ArrayList<>();
        for (Integer indexI : mnozinaIMensiaAlpha) {
            for (int j = 0; j < size; j++) {
                int vectorNumber = vectorX.get(j);
                int matrixRowNumber = maticaB.get(indexI).get(j);

                int current = vectorNumber < matrixRowNumber ? vectorNumber : matrixRowNumber;

                if (current > alpha && !mnozinaJ.contains(j)) {
                    mnozinaJ.add(j);
                }
            }
        }

        // KROK 5
        for (Integer indexJ : mnozinaJ) {
            vectorX.set(indexJ, alpha);
        }

        for (Integer indexI : mnozinaIMensiaAlpha) {
            if (!mnozinaIRovnaAlpha.contains(indexI)) {
                mnozinaIRovnaAlpha.add(indexI);
            }
        }

        if (mnozinaIRovnaAlpha.size() == size) {
            return vectorX;
        } else {
            return getVectorX(maticaA, maticaB, vectorX);
        }
    }
}

