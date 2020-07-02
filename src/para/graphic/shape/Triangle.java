package para.graphic.shape;
import para.graphic.target.Target;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.min;

public class Triangle extends Shape{
    /** 属性 */
    private Attribute attr;
    /** 1つ目のx座標 */
    private int x0;
    /** 1つ目のy座標 */
    private int y0;
    /** 2つ目のx座標 */
    private int x1;
    /** 2つ目のy座標 */
    private int y1;
    /** 3つ目のx座標 */
    private int x2;
    /** 3つ目のy座標 */
    private int y2;

    /** 三角形を出力する．
     *  @param id 三角形の識別子
     *  @param x0 1つ目の点のx座標
     *  @param y0 1つ目の点のy座標
     *  @param x1 2つ目の点のx座標
     *  @param y1 2つ目の点のy座標
     *  @param x2 3つ目の点のx座標
     *  @param y2 3つ目の点のy座標
     */
    public Triangle(int id, int x0, int y0, int x1, int y1,int x2,int y2){
        this(id, x0, y0, x1, y1,x2,y2 ,null);
    }
    /** 三角形を出力する．
     *  @param id 三角形の識別子
     *  @param x0 1つ目の点のx座標
     *  @param y0 1つ目の点のy座標
     *  @param x1 2つ目の点のx座標
     *  @param y1 2つ目の点のy座標
     *  @param x2 3つ目の点のx座標
     *  @param y2 3つ目の点のy座標
     *  @param attr 矩形の属性
     */
    public Triangle(int id, int x0, int y0, int x1, int y1, int x2,int y2,Attribute attr){
        super(id, Math.min(x0,Math.min(x1,x2)),Math.max(x0,Math.max(x1,x2)),Math.max(y0,Math.max(y1,y2)),Math.min(y0,Math.min(y1,y2)));
        this.x0 =x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.attr = attr;
    }



    /**
     * 属性を取得する
     */
    @Override
    public Attribute getAttribute() {
        return attr;
    }

    /** この三角形を出力する．
     *  @param target 出力先
     */
    @Override
    public void draw(Target target) {
        target.drawTriangle(id, x0, y0, x1, y1,x2,y2,attr);
    }
}
