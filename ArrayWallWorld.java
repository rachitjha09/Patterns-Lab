import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ArrayWallWorld extends World
{

    /**
     * Constructor for objects of class NoOverlapWorld.
     * 
     */
    public ArrayWallWorld(int numRows, int numCols )
    {    
        // rows and columns are opposite of x and y of normal Worlds
        super(numCols, numRows, 20); 
        drawGrid();
    }

    public void addObject( Actor a, int row, int col )
    {
        try
        {
            super.addObject( a, col, row  );
        }
        catch ( Exception e )
        {
            System.out.printf( "Row: %d, Col: %c is not in the bounds of the grid.", row, col );
        }
    }

    private void drawGrid()
    {
        GreenfootImage bg = getBackground();
        bg.setColor( Color.LIGHT_GRAY );
        for ( int x = 1; x < getWidth(); x++ )
        {
            bg.drawLine( x * getCellSize(), 0, x * getCellSize(), getHeight() * getCellSize() );
        }
        for ( int y = 1; y < getHeight(); y++ )
        {
            bg.drawLine( 0, y * getCellSize(), getWidth() * getCellSize(), y * getCellSize() );
        }
    }

    // Removes all objects from the screen
    public void removeAll()
    {
        removeObjects( getObjects(null) );
    }

    public void draw2D( boolean [][] mat )
    {
        removeAll();
        for ( int r = 0; r < mat.length; r++ )
        {
            for ( int c = 0; c < mat[r].length; c++ )
            {
                if ( mat[r][c] )
                {
                    //Remember, rows and columns are usually backwards of x and y coordinates
                    addObject( new Wall(), r, c );
                }
            }
        }
    }

    public int getNumRows()
    {
        return getHeight();
    }

    public int getNumCols()
    {
        return getWidth();
    }

}
