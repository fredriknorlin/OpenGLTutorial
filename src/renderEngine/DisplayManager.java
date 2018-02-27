package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 144;

    public static void createDisplay(){
        ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);

        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("New Title added");
        }
        catch(LWJGLException e){
            e.printStackTrace();
        }
    }

    public static void updateDisplay(){
        Display.sync(FPS_CAP);
        Display.update();
    }

    public static void closeDisplay(){
        Display.destroy();
    }
}
