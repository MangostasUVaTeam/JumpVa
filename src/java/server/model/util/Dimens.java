/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.util;

import java.io.Serializable;

/**
 *
 * @author garciparedes
 */
public class Dimens implements Serializable {

    public Dimens(double height, double width, double depth, DimensType type) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.type = type;
    }

    public Dimens() {
    }
    private DimensType type;
    private double height;
    private double width;
    private double depth;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
