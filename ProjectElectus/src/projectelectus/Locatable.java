package projectElectus;

/**
 * This class creates the interface implemented by Platform.java and used by its subclasses.
 * @author Jack Baumann
 */
public interface Locatable
{
    /**
     * This method sets the x and y coordinates on the canvas for the Locatable.
     * @param x - the x coordinate of the Locatable
     * @param y - the y coordinate of the Locatable
     */
    public void setPos(double x, double y);
    /**
     * This method sets the x coordinate on the canvas for the Locatable.
     * @param x  - the x coordinate of the Locatable
     */
    public void setX(double x);
    /**
     * This method sets the y coordinate on the canvas for the Locatable.
     * @param y  - the y coordinate of the Locatable
     */
    public void setY(double y);
    /**
     * This method returns the x coordinate of the Locatable.
     * @return the x coordinate of the Locatable
     */
    public double getX();
    /**
     * This method returns the y coordinate of the Locatable.
     * @return the y coordinate of the Locatable
     */
    public double getY();
}