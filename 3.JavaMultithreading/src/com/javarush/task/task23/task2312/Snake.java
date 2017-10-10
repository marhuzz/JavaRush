package com.javarush.task.task23.task2312;

import java.util.*;

/**
 * Created by Marhuz on 14.02.2017.
 */
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;

    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){
        if (isAlive == false) {return;}

        if (direction == SnakeDirection.UP){
            move(0,-1);
        }
        if (direction == SnakeDirection.DOWN){
            move(0,1);
        }
        if (direction == SnakeDirection.RIGHT){
            move(1,0);
        }
        if (direction == SnakeDirection.LEFT){
            move(-1,0);
        }
    }

    public void checkBorders(SnakeSection head){
        if (head.getY() >= Room.game.getHeight() || head.getY()<0){isAlive=false;}
        if (head.getX() >= Room.game.getWidth() || head.getX()<0){isAlive=false;}

    }

    public void checkBody(SnakeSection head){
        if (sections.contains(head)){isAlive=false;}
    }

    public void move (int a, int b){}

}
