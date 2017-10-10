/**
 * Created by Marhuz on 02.10.2017.
 */
public class DelegateApp {
    interface Graphics{
        void draw();
    }

    class Triangle implements Graphics{
        @Override
        public void draw() {
            System.out.println("Рисуем треугольник");
        }
    }

    class Square implements Graphics{
        @Override
        public void draw() {
            System.out.println("Рисуем квадрат");
        }
    }

    class Circle implements Graphics{
        @Override
        public void draw() {
            System.out.println("Рисуем круг");
        }
    }

    class Painter{
        Graphics graphics;

        void setGraphics(Graphics g){
            graphics = g;
        }

        void draw(){
            graphics.draw();
        }

    }

}
