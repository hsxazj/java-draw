package cn.xiake_hf.shape;

import java.awt.*;

/**
 *  
 */
public class Pentagon extends AbstractShape {


    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(color);
        g2d.setStroke(new BasicStroke(width));
        int[] x = {(x1 + x2) / 2, Math.min(x1, x2), Math.min(x1, x2) + Math.abs(x1 - x2) / 4,
                Math.max(x1, x2) - Math.abs(x1 - x2) / 4, Math.max(x1, x2)};
        int[] y = {Math.min(y1, y2), (int) (Math.min(y1, y2) + Math.abs(y1 - y2) / 2.5), Math.max(y1, y2),
                Math.max(y1, y2), (int) (Math.min(y1, y2) + Math.abs(y1 - y2) / 2.5)};
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawPolygon(x, y, 5);
    }
}