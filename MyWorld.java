import greenfoot.*;

public class MyWorld extends ArrayWallWorld
{
    private static final int DEFAULT_ROWS = 30;
    private static final int DEFAULT_COLS = 40;

    public MyWorld()
    {    
        super(DEFAULT_ROWS, DEFAULT_COLS );
    }

    public MyWorld( int numRows, int numCols )
    {
        super( numRows, numCols );
    }

    public void allMiddle()
    {
        boolean [][] walls = new boolean[getNumRows()][getNumCols()];

        for ( int r = 1; r < walls.length - 1; r++ )
        {
            for ( int c = 1; c < walls[r].length - 1; c++ )
            {
                walls[r][c] = true;
            }
        }
        draw2D( walls );
    }

    public void border()
    {        
        boolean [][] walls = new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<1; r++){
            for(int c=0; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        for(int r=getNumRows()-1; r>getNumRows()-2; r--){
            for(int c=0; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        //for(int c=0; c<1; c++){
        for(int r=0; r<walls.length; r++){
            walls[r][0]=true;
            walls[r][getNumCols()-1]=true;
        }
        
        
        draw2D(walls);
    }

    public void checkered()
    {
        boolean [][] walls = new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            if(r%2==0){
                for(int c=0; c<walls[r].length; c+=2){
                    walls[r][c]=true;
                }
            }
        }
        draw2D(walls);
    } 

    public void diagonals()
    {
        boolean [][] walls=new boolean[getNumRows()][getNumCols()];
        int c=0;
        for (int r=0; r<walls.length; r++){
                walls[r][c]=true;
                walls[r][walls.length-c-1]=true;
                c++;
        }
        draw2D(walls);

    }
    public double distance(int x, int y, int z, int i){
        double d=Math.sqrt(Math.pow((x-z), 2)+Math.pow((y-i),2));
        return d;
    }
    public void exterior()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int x=walls[0].length/2;
        int y=walls.length/2;
        int d=Math.min(walls.length, walls[0].length);
        int r=d/2;
        for(int i=0; i<walls.length; i++){
            for(int j=0; j<walls[r].length; j++){
                if(distance(x, y, j, i)>=r){
                    walls[i][j]=true;
                }
            }
        }
        draw2D(walls);

    }

    public void fibonacci()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int f=0;
        int s=1;
        int i[]=new int[10];
        int t=0;
        for(int j=0; j<i.length; j++){
            i[j]=f;
            int n=f+s;
            f=s;
            s=n;
        }
        for(int x=0; x<walls.length; x+=4){
            if(t<i.length-1){
                t++;
            }
            for(int r=0; r<i[t]; r++){
                walls[x][r]=true;
            }
        }
        draw2D(walls);

    }

    public void geometricSeries()
    {
        boolean [][] walls=new boolean[getNumRows()][getNumCols()];
        int i=0;
        for (int r=0; r<walls.length; r+=3){
            if (Math.pow(2,i)<walls[0].length){
                for(int c=0; c<Math.pow(2,i); c++){
                    walls[r][c]=true;
                }
            }else{
                for(int c=0; c< walls[0].length; c++)
                    walls[r][c]=true;
            }
            i++;
        }
        draw2D(walls);
    }  

    public void hemisphereLeft()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int x=getNumCols()/2;
        for (int r=0; r<walls.length; r++){
            for (int c=0; c<x; c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);

    }

    public void hemisphereRight()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int x=getNumCols()/2;
        for(int r=0; r<walls.length; r++){
            for(int c=x; c<getNumCols(); c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);

    }

    public void hemisphereTop()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int x=getNumRows()/2;
        for(int r=0; r<x; r++){
            for(int c=0; c<getNumCols(); c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);

    }

    public void hemisphereBottom()
    {  
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        int x=getNumRows()/2;
        for(int r=x; r<getNumRows(); r++){
            for(int c=0; c<getNumCols(); c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);

    }

    public void isosclesRightA()
    {  
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            for(int c=0; c<walls[r].length/2-r+3; c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);

    }

    public void isosclesRightB()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            for(int c=0; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        for(int r=0; r<walls.length; r++){
            for(int c=r; c<walls[r].length; c++){
                walls[r][c]=false;
            }
        }
        draw2D(walls);

    }    

    public void isosclesRightC()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            for(int c=r+20; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);
    }

    public void isosclesRightD()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            for(int c=0; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        for(int r=0; r<walls.length; r++){
            for(int c=0; c<walls[r].length-r; c++){
                walls[r][c]=false;
            }
        }
        draw2D(walls);

    }      

    public void jaggedSteps()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=1; r<walls.length; r+=4){
            for(int c=0; c<walls[r].length-1; c++){
                walls[r][c]=true;
            }
        }
        for(int r=3; r<walls.length; r+=4){
            for(int c=1; c<walls[r].length; c++){
                walls[r][c] = true;
            }
        }
        draw2D(walls);
    }
    
    public void knitting() 
    {
        boolean[][] walls = new boolean[getNumRows()][getNumCols()];
    
        for(int r=0; r<getNumRows(); r++){
            if(r%6==0){
                for(int c=4; c<walls[r].length; c+=6){
                    walls[r][c]=true;
                }
            } else if(r%6==1){
                for(int c=0; c<walls[r].length-4; c+=6){
                    walls[r][c]=true;
                    walls[r][c+1]=true;
                    walls[r][c+2]=true;
                    walls[r][c+4]=true;
                }
                walls[r][getNumCols()-2]=true;
                walls[r][getNumCols()-1]=true;
            } else if(r%6==2){
                for(int c=4; c<walls[r].length; c+=6){
                    walls[r][c]=true;
                }
            } else if(r%6==3){
                for(int c=1; c<walls[r].length; c+=6){
                    walls[r][c]=true;
                }
            } else if(r%6==4){
                for(int c=1; c<walls[r].length-4; c+=6){
                    walls[r][c]=true;
                    walls[r][c+2]=true;
                    walls[r][c+3]=true;
                    walls[r][c+4]=true;
                }
                walls[r][getNumCols()-3]=true;
            } else if(r%6==5){
                for(int c=1; c<walls[r].length; c+=6){
                    walls[r][c]=true;
                }
            }
        }
        draw2D(walls);
    }

    public void longitudes()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=0; r<walls.length; r++){
            for(int c=1; c<walls[r].length; c+=3){
                walls[r][c]=true;
            }
        }
        draw2D(walls);
    }

    public void latitudes()
    {
        boolean[][] walls=new boolean[getNumRows()][getNumCols()];
        for(int r=1; r<walls.length; r+=3){
            for(int c=0; c<walls[r].length; c++){
                walls[r][c]=true;
            }
        }
        draw2D(walls);
    }

    public void act()
    {
        if ( Greenfoot.isKeyDown( "a" ) )
        {
            this.allMiddle();
        }
        if ( Greenfoot.isKeyDown( "b" ) )
        {
            this.border();
        }
        if ( Greenfoot.isKeyDown( "c" ) )
        {
            this.checkered();
        }
        if ( Greenfoot.isKeyDown( "d" ) )
        {
            this.diagonals();
        }
        if ( Greenfoot.isKeyDown( "e" ) )
        {
            this.exterior();
        }
        if ( Greenfoot.isKeyDown( "f" ) )
        {
            this.fibonacci();
        }
        if ( Greenfoot.isKeyDown( "g" ) )
        {
            this.geometricSeries();
        }
        if ( Greenfoot.isKeyDown( "h" ) && Greenfoot.isKeyDown( "1" ) )
        {
            this.hemisphereLeft();
        }
        if ( Greenfoot.isKeyDown( "h" ) && Greenfoot.isKeyDown( "2" ) )
        {
            this.hemisphereRight();
        }
        if ( Greenfoot.isKeyDown( "h" ) && Greenfoot.isKeyDown( "3" ) )
        {
            this.hemisphereTop();
        }
        if ( Greenfoot.isKeyDown( "h" ) && Greenfoot.isKeyDown( "4" ) )
        {
            this.hemisphereBottom();
        }
        if ( Greenfoot.isKeyDown( "i" ) && Greenfoot.isKeyDown( "1" ))
        {
            this.isosclesRightA();
        }
        if ( Greenfoot.isKeyDown( "i" ) && Greenfoot.isKeyDown( "2" ))
        {
            this.isosclesRightB();
        }
        if ( Greenfoot.isKeyDown( "i" ) && Greenfoot.isKeyDown( "3" ))
        {
            this.isosclesRightC();
        }
        if ( Greenfoot.isKeyDown( "i" ) && Greenfoot.isKeyDown( "4" ))
        {
            this.isosclesRightD();
        }
        if ( Greenfoot.isKeyDown( "j" ) )
        {
            this.jaggedSteps();
        }
        if ( Greenfoot.isKeyDown( "k" ) )
        {
            this.knitting();
        }
        if ( Greenfoot.isKeyDown( "l" ) && Greenfoot.isKeyDown( "1" ))
        {
            this.latitudes();
        }
        if ( Greenfoot.isKeyDown( "l" ) && Greenfoot.isKeyDown( "2" ))
        {
            this.longitudes();
        }
        if ( Greenfoot.isKeyDown( "F1" ) )
        {
            MyWorld w = new MyWorld(DEFAULT_ROWS, DEFAULT_COLS);
            Greenfoot.setWorld( w );
        }

        if ( Greenfoot.isKeyDown( "F2" ) )
        {
            MyWorld w = new MyWorld( DEFAULT_COLS, DEFAULT_ROWS );
            Greenfoot.setWorld( w );
        }

        if ( Greenfoot.isKeyDown( "F3" ) )
        {
            MyWorld w = new MyWorld( DEFAULT_ROWS / 2, DEFAULT_COLS / 2 );
            Greenfoot.setWorld( w );
        }

        if ( Greenfoot.isKeyDown( "F4" ) )
        {
            MyWorld w = new MyWorld( DEFAULT_COLS / 2, DEFAULT_ROWS / 2 );
            Greenfoot.setWorld( w );
        }

        if ( Greenfoot.isKeyDown( "F5" ) )
        {
            int randRow = (int)(Math.random() * 50 ) + 10;
            int randCol = (int)(Math.random() * 50 ) + 10;

            MyWorld w = new MyWorld( randRow / 2, randCol / 2 );
            Greenfoot.setWorld( w );
        }
    }
}