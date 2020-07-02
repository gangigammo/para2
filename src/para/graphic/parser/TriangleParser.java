package para.graphic.parser;

import para.graphic.shape.Attribute;
import para.graphic.shape.Rectangle;
import para.graphic.shape.Triangle;

import java.util.Scanner;

public class TriangleParser implements ShapeParser{
    TriangleParser(){

    }
    @Override
    public Triangle parse(Scanner s, int id){
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        Triangle tri;
        Attribute attr=null;
        if(s.hasNext("Attribute")){
            attr = AttributeParser.parse(s);
        }
        tri = new Triangle(id,x0,y0,x1,y1,x2,y2,attr);
        return tri;
    }

}
