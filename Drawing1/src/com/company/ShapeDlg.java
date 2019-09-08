package com.company;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;

import java.awt.*;

public class ShapeDlg extends Dialog
{
    ShapeDlg(){}
    public void finalizee(){}
    protected void DoDataExchange(){}
    public boolean OnInilDialog()
    {
        return true;
    }
    
    public int m_Type;
    public int m_x;
    public int m_y;
    public int m_w;
    public int m_h;
    String m_text;
    public int m_pen_width;
    public int m_pen_type;
    public int m_brush_type;
    public Color m_pen_color;
    public Color m_brush_color;
    public ComboBox m_ctlType;
    
}
