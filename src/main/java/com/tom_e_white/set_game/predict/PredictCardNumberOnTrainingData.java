package com.tom_e_white.set_game.predict;

import boofcv.io.image.UtilImageIO;
import com.tom_e_white.set_game.train.FindCardNumberFeatures;

import java.io.File;
import java.io.IOException;

/**
 * Use {@link FindCardNumberFeatures} to predict the number of shapes on each card in the training set.
 * This is OK since we don't actually train a model for number - we just do clever image processing.
 */
public class PredictCardNumberOnTrainingData {

    public static double computeAccuracyOnTrainingData() throws IOException {
        FindCardNumberFeatures cardFeatureCounter = new FindCardNumberFeatures();
        int correct = 0;
        int total = 0;
        for (File file : new File("data/train-out").listFiles((dir, name) -> name.matches(".*\\.jpg"))) {
            System.out.println(file);
            int predictedNumber = (int) cardFeatureCounter.find(UtilImageIO.loadImage(file.getAbsolutePath()), false)[0];
            int actualNumber = cardFeatureCounter.getLabelFromFilename(file.getName());
            if (predictedNumber == actualNumber) {
                correct++;
            } else {
                System.out.println("Incorrect, predicted " + predictedNumber);
            }
            total++;
        }
        System.out.println("Correct: " + correct);
        System.out.println("Total: " + total);
        double accuracy = ((double) correct)/total * 100;
        System.out.println("Accuracy: " + ((int) accuracy) + " percent");
        return accuracy;
    }
    public static void main(String[] args) throws IOException {
        computeAccuracyOnTrainingData();
    }
}
