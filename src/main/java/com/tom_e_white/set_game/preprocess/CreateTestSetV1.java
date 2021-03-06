package com.tom_e_white.set_game.preprocess;

import boofcv.io.image.UtilImageIO;
import com.tom_e_white.set_game.preprocess.CardDetector;
import com.tom_e_white.set_game.preprocess.CardImage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Use {@link CardDetector} to create a test set of cards.
 */
public class CreateTestSetV1 {
    public static void main(String[] args) {
        CardDetector cardDetector = new CardDetector();
        File outDir = new File("data/test-out");
        outDir.mkdirs();
        File file = new File("data/20170106_205743.jpg");
        try {
            System.out.println(file);
            List<CardImage> images = cardDetector.detect(file.getAbsolutePath());
            int i = 1;
            for (CardImage image : images) {
                File newFile = new File(outDir, file.getName().replace(".jpg", "_" + i++ + ".jpg"));
                UtilImageIO.saveImage(image.getImage(), newFile.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
