package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
public class KursachGUI extends JFrame {
    private JButton button = new JButton("Press1");
    private JLabel label = new JLabel("Send sort metod");
    private JRadioButton radio1= new JRadioButton("bouble sort");
    private JRadioButton radio2= new JRadioButton("selection sort");
    private JRadioButton radio3= new JRadioButton("insertion sort");
    private JRadioButton radio4= new JRadioButton("Quick sort");

    public KursachGUI(){
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,4,4,4));
        container.add(label);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);
        container.add(radio1);
        container.add(radio2);
        container.add(radio3);
        container.add(radio4);
        radio4.setSelected(true);
        button.addActionListener(new ButtonEventListener());
        container.add(button);


    }
    class ButtonEventListener implements ActionListener{
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        public void actionPerformed(ActionEvent e){
            String massage="";
            massage+="Массив отсортирован методом\n";

            if(radio1.isSelected()==true){
                massage+="bouble sort";
                boubleSort(array);
                massage+= Arrays.toString(array);
            }
            if(radio2.isSelected()==true){
                massage+="selection sort";
                selectionSort(array);
                massage+= Arrays.toString(array);
            }
            if(radio3.isSelected()==true){
                massage+="insertion sort";
                insertionSort(array);
                massage+= Arrays.toString(array);
            }
            if(radio4.isSelected()==true){
                massage+="Quick sort";
                quickSort(array,0,array.length-1);
                massage+= Arrays.toString(array);
            }

            JOptionPane.showMessageDialog(null,massage,"otput",JOptionPane.PLAIN_MESSAGE);

        }

    }
    public static void swapp(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    public static void boubleSort(int[] array){
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swapp(array, i, i-1);
                    needIteration = true;
                }
            }
        }
    }
    public static void selectionSort(int[] array){
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swapp(array, left, minInd);
        }
    }
    public static void insertionSort(int[] array){
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
    }
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }


}