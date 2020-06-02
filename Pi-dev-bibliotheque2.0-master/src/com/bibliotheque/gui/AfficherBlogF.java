/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotheque.gui;

import com.bibliotheque.Service.BlogServices;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.bibliotheque.Entite.Blog;
import java.io.IOException;

/**
 *
 * @author Daly
 */
public class AfficherBlogF {

    Form f = new Form("Blog");
    private EncodedImage ei;
    private Resources theme;

    public void afficherBlogs() {
        theme = UIManager.initFirstTheme("/theme");
        try {
            ei = EncodedImage.create("/loading.jpg");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        BlogServices bs = new BlogServices();
        for (Blog b : bs.afficherBlog()) {

            Label sujetLabel = new Label("Sujet :"); //hedha label
            Label VarsujetLabel = new Label(); //bien hh
            Label DescLabel = new Label("Description :");
            Label VarDescLabel = new Label("Description :");

            Container IMG = new Container();
            Image img = URLImage.createToStorage(ei, b.getType(),
                    "http://localhost/projetwahdyy/web/images/" + b.getType(), URLImage.RESIZE_SCALE_TO_FILL);

            IMG.setPreferredSize(new Dimension(406, 800));

            img.scale(5, 5);
            ImageViewer iv = new ImageViewer(img);

            IMG.add(iv);
            Container containerSujet = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container containerDes = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container containerSujet_Des = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container containerImage = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container containerAll = new Container(new BoxLayout(BoxLayout.X_AXIS));

            VarsujetLabel.setText(b.getSujet());
            VarDescLabel.setText(b.getDescription());

            containerSujet.addAll(sujetLabel, VarsujetLabel);
            containerDes.addAll(DescLabel, VarDescLabel);
            containerSujet_Des.addAll(containerSujet, containerDes);

            containerImage.addAll(containerSujet_Des, IMG);
            containerAll.addAll(containerImage);
            //  containerAll.getAllStyles().setPaddingBottom(1);
            f.add(containerAll);
        }

        f.getToolbar().addCommandToLeftBar("Logout", theme.getImage("back-command.png"), e -> {
           new SignInForm(theme).show();
        });

        f.addPullToRefresh(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
                f.removeAll();
                afficherBlogs();
            }
        });
        f.show();

    }

}
