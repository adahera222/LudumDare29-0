package com.gregswebserver.ld28.util.vectors;

public class Vector2d extends Vector<Double> {

    public Vector2d() {
        x = y = (double) 0;
    }

    public Vector2d(double s) {
        this.x = s;
        this.y = s;
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d in) {
        this.x = in.x;
        this.y = in.y;
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public Vector2d multiply(double scale) {
        x *= scale;
        y *= scale;
        return this;
    }

    public Vector2d add(Vector2d in) {
        this.x += in.x;
        this.y += in.y;
        return this;
    }

    public Vector2d subtract(Vector2d in) {
        this.x -= in.x;
        this.y -= in.y;
        return this;
    }

    public Vector2d rotate(double degrees) {
        double rads = degrees * Math.PI / 180;
        this.x = (x * Math.cos(rads)) - (y * Math.sin(rads));
        this.y = (y * Math.cos(rads)) + (x * Math.sin(rads));
        return this;
    }

    public Vector2d flip() {
        double a = x;
        this.x = y;
        this.y = a;
        return this;
    }

    public int getQuadrant() {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        return 0;
    }

    public int getDirection() {
        if (Math.abs(x) < Math.abs(y) && y > 0) return 1;
        if (Math.abs(x) > Math.abs(y) && x > 0) return 2;
        if (Math.abs(x) < Math.abs(y) && y < 0) return 3;
        if (Math.abs(x) > Math.abs(y) && x < 0) return 4;
        return 0;
    }

    public boolean contains(Vector2i in) {
        if (getQuadrant() != in.getQuadrant()) return false;
        switch (in.getQuadrant()) {
            case 1:
                return getY() > in.getY() && getX() > in.getX();
            case 2:
                return getY() > in.getY() && getX() < in.getX();
            case 3:
                return getY() < in.getY() && getX() < in.getX();
            case 4:
                return getY() < in.getY() && getX() > in.getX();
            default:
                return false;
        }
    }

    public double dot(Vector2d in) {
        return this.x * in.x + this.y * in.y;
    }

    public Vector2i toVector2i() {
        return new Vector2i(x.intValue(), y.intValue());
    }

    public Vector2d unit() {
        return new Vector2d(this).multiply(1 / length());
    }

    public Vector2d copy(){
        return new Vector2d(this);
    }
}
