/*
 Violet - A program for editing UML diagrams.

 Copyright (C) 2007 Cay S. Horstmann (http://horstmann.com)
 Alexandre de Pellegrin (http://alexdp.free.fr);

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.horstmann.violet.product.diagram.abstracts.edge;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import com.horstmann.violet.product.diagram.abstracts.Direction;
import com.horstmann.violet.product.diagram.abstracts.IIdentifiable;
import com.horstmann.violet.product.diagram.abstracts.node.INode;

/**
 * An edge in a graph.
 */
public interface IEdge extends Serializable, Cloneable, IIdentifiable
{

    void deserializeSupport();

    /**
     * Sets the starting node_old
     * 
     * @param startingNode
     */
    void setStart(INode startingNode);

    /**
     * Gets the starting node_old.
     * 
     * @return the starting node_old
     */
    INode getStart();

    /**
     * Sets the ending node_old
     * 
     * @param endingNode
     */
    void setEnd(INode endingNode);

    /**
     * Gets the ending node_old.
     * 
     * @return the ending node_old
     */
    INode getEnd();

    /**
     * Sets the point from where this edge begins (relative to the starting node_old)
     * 
     * @param startingLocation
     */
    void setStartLocation(Point2D startingLocation);

    /**
     * @return the point from where this end begins location (relative to the starting node_old)
     */
    Point2D getStartLocation();

    /**
     * Sets the point where this node_old ends (relative to the ending node_old)
     * 
     * @param endingLocation
     */
    void setEndLocation(Point2D endingLocation);

    /**
     * @return the point where this node_old ends (relative to the ending node_old)
     */
    Point2D getEndLocation();
    
    /**
     * Sets transition points for edge which supports free path 
     * @param transitionPoints
     */
    void setTransitionPoints(Point2D[] transitionPoints);
    
    /**
     * @return transition points for edge which supports free path
     */
    Point2D[] getTransitionPoints();
    
    /**
     * @return true if the edge supports free path
     */
    boolean isTransitionPointsSupported();

    /**
     * Gets the points at which this edge is connected to its nodes.
     * 
     * @return a line joining the two connection points
     */
    Line2D getConnectionPoints();

    /**
     * Tests whether the edge contains a point.
     * 
     * @param aPoint the point to test
     * @return true if this edge contains aPoint
     */
    boolean contains(Point2D aPoint);

    /**
     * Gets the smallest rectangle that bounds this edge. The bounding rectangle contains all labels.
     * 
     * @return the bounding rectangle
     */
    Rectangle2D getBounds();
    
    
    /**
     * Gets edge's direction for this node_old
     * 
     * @return direction or null if this edge is not connected to this node_old
     */
    Direction getDirection(INode node);

    /**
     * Draw the edge.
     * 
     * @param g2 the graphics context
     */
    void draw(Graphics2D g2);

    /**
     * Gets current edge tool tip
     * 
     * @return s
     */
    String getToolTip();

    /**
     * @return a deep copy of this object
     */
    IEdge clone();

}
