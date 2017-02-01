package ua.goit.enterprise.module1;

// Імпортує swing і AWT класи
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class SwingExample {
    public static void main(String[] args) {

        // Упевнюємося, що всі виклики Swing/AWT виконуються Event Dispatch Thread ("EDT")
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Створюємо JFrame, що має вигляд вікна з "декораціями",
                // наприклад заголовком і кнопкою закриття
                JFrame f = new JFrame("Приклад вікна Swing");

                // Установлюємо простий менеджер розмітки, що впорядковує всі компоненти
                f.setLayout(new FlowLayout());

                // Додаємо компоненти
                f.add(new JLabel("Ця кнопка не робить нічого:"));
                f.add(new JButton("Натисніть сюди!"));

                // "Пакує" вікно, тобто робить його величину відповідну до її компонентів
                f.pack();

                // Встановлюємо стандартну операцію закриття для вікна,
                // без цього вікно не закриється після активування кнопки закриття
                //  (Стандартно HIDE_ON_CLOSE, що просто приховує вікно)
                f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                // Уснановлюємо видимість=істина, тим самим показуючи вікно на екрані
                f.setVisible(true);
            }
        });
    }
}
