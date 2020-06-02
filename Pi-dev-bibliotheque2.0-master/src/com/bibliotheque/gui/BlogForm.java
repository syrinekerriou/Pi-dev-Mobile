package com.bibliotheque.gui;

import com.bibliotheque.Service.BlogServices;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.bibliotheque.Entite.Blog;
import java.io.IOException;


public class BlogForm extends BaseForm {
    
     private EncodedImage ei;

    public BlogForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    public BlogForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Blog", "Title")
                )
        );

        installSidemenu(resourceObjectInstance);

        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });

        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);

        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder) fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());

            Button c1 = new Button(resourceObjectInstance.getImage("contact-a.png"));
            Button c2 = new Button(resourceObjectInstance.getImage("contact-b.png"));
            Button c3 = new Button(resourceObjectInstance.getImage("contact-c.png"));
            Button trans = new Button(" ");
            trans.setUIID("Container");
            c1.setUIID("Container");
            c2.setUIID("Container");
            c3.setUIID("Container");
            Style c1s = c1.getAllStyles();
            Style c2s = c2.getAllStyles();
            Style c3s = c3.getAllStyles();

            c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c2s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c3s.setMarginUnit(Style.UNIT_TYPE_DIPS);

            c1s.setMarginBottom(16);
            c1s.setMarginLeft(12);
            c1s.setMarginRight(3);

            c2s.setMarginLeft(4);
            c2s.setMarginTop(5);
            c2s.setMarginBottom(10);
            c3s.setMarginRight(14);

            c3s.setMarginTop(12);
            c3s.setMarginRight(16);

            popup.add(trans).
                    add(FlowLayout.encloseIn(c1)).
                    add(FlowLayout.encloseIn(c2)).
                    add(FlowLayout.encloseIn(c3));

            ActionListener a = ee -> popup.dispose();

            trans.addActionListener(a);
            c1.addActionListener(a);
            c2.addActionListener(a);
            c3.addActionListener(a);

            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = BlogForm.this.getTintColor();
            BlogForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(BlogForm.this.getWidth() - 10, BlogForm.this.getHeight() - 10, 10, 10));
            BlogForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
    }

////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("InboxForm");
        setName("InboxForm");
        
        try {
            ei = EncodedImage.create("/loading.jpg");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
           
        BlogServices bs = new BlogServices();
        for (Blog b : bs.afficherBlog()) {
            // DECLARATION 
          Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
     com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
     com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
     com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
     com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
     com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
     com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
     com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
     com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
     com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
     com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
     com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
     com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
     com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
     com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
     com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
     com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
     com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
     com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
     com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
     com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
     com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();

            //END DECLARATION
             gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_1.setName("Container_1");
            gui_Label_6.setText("");
            gui_Label_6.setUIID("Separator");
            gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_6.setName("Label_6");
            gui_Container_1_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_1_1.setName("Container_1_1");
            gui_Label_7.setText("");
            gui_Label_7.setUIID("Separator");
            gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_7.setName("Label_7");
            gui_Container_1_2.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_1_2.setName("Container_1_2");
            gui_Label_8.setText("");
            gui_Label_8.setUIID("Separator");
            gui_Label_8.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_8.setName("Label_8");
            gui_Container_1_3.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_1_3.setName("Container_1_3");
            gui_Label_9.setText("");
            gui_Label_9.setUIID("Separator");
            gui_Label_9.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_9.setName("Label_9");
            gui_Container_1_4.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_1_4.setName("Container_1_4");
            gui_Label_5.setText("");
            gui_Label_5.setUIID("Separator");
            gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_5.setName("Label_5");
            addComponent(gui_Container_1);
            gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_2.setName("Container_2");
            gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout) gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_3.setName("Container_3");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
            gui_Label_1.setText("11:31 AM");
            gui_Label_1.setUIID("SmallFontLabel");
            gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_1.setName("Label_1");
            gui_Container_2.addComponent(gui_Label_1);
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Label_4.setUIID("Padding2");
            gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_4.setName("Label_4");
            gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
            gui_Container_4.addComponent(gui_Label_4);
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);

            gui_Label_3.setText(b.getSujet());
//            gui_Label_3.addPointerPressedListener(new ActionListener() {
//              @Override
//              public void actionPerformed(ActionEvent evt) {
//                  new CommentaireForm(resourceObjectInstance).show();
//              }
//          });
            gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_3.setName("Label_3");
            gui_Label_2.setText(b.getDescription());
            gui_Label_2.setUIID("RedLabel");
            gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
            gui_Label_2.setName("Label_2");
             Container IMG = new Container();
            Image img = URLImage.createToStorage(ei, b.getType(),
                    "http://localhost/pi-dev/web/images/" + b.getType(), URLImage.RESIZE_SCALE_TO_FILL);

            IMG.setPreferredSize(new Dimension(900, 700));

            img.scale(20, 20);
            ImageViewer iv = new ImageViewer(img);

            IMG.add(iv);
           
            gui_Text_Area_1.setText("Hi Adrian, there is a new announcement for you from Oxford  Learning  Lab. Hello we completly...");
            gui_Text_Area_1.setUIID("SmallFontLabel");
            gui_Text_Area_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Text_Area_1.setName("Text_Area_1");
            gui_Text_Area_1.setColumns(100);
            gui_Text_Area_1.setRows(2);
            gui_Container_3.addComponent(gui_Label_3);
            gui_Container_3.addComponent(gui_Label_2);
            gui_Container_3.addComponent(IMG);
            addComponent(gui_Label_6);
            addComponent(gui_Container_1_1);
            gui_Container_2_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_2_1.setName("Container_2_1");
            gui_Container_4_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_4_1.setName("Container_4_1");
            ((com.codename1.ui.layouts.FlowLayout) gui_Container_4_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_3_1.setInlineStylesTheme(resourceObjectInstance);
            gui_Container_3_1.setName("Container_3_1");
            gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_1);

            addComponent(gui_Label_5);
        }
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
