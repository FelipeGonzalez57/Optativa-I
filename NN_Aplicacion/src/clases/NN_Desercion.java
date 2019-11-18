/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;

/**
 *
 * @author SOMA-FELIPE
 */
public class NN_Desercion {

    public static void main(String[] args) {
        // create new perceptron network 
        NeuralNetwork neuralNetwork = new MultiLayerPerceptron(7, 14, 1);
        // create training set 
        DataSet trainingSet = new DataSet(7, 1);
        // add training data to training set (logical OR function) 
        trainingSet.add(new DataSetRow(new double[]{1, 1, 0, 1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 1, 0, 0, -1, 1, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 0, 0, 0, 0, 0}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 1, 1, 1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 0, 1, 0, 1, 0, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 0, 1, -1, -1, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{-1, 0, 1, 1, -1, 0, 0}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 1, 1, 0, 0, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 0, -1, 1, -1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{-1, 1, 0, 0, 0, -1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 0, -1, 0, 1, -1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 1, 0, 1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 0, 1, 0, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 0, 1, 0, 0, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 0, 1, 1, 0, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{1, 1, 0, 0, 1, 1, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{-1, 0, 1, -1, 1, 1, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{1, 0, 0, 1, 1, 1, -1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 1, 1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 1, 1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 1, 0, 0, 0, 0}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{-1, 0, 1, -1, 1, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 1, 0, 0, 0, 0}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 0, 1, 0, 0, 1, 1}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1, 1, -1, 0, 1, 1}, new double[]{0}));

        // learn the training set 
        neuralNetwork.learn(trainingSet);

        // save the trained network into file 
        neuralNetwork.save("desercion_multilayer.nnet");

        // load the saved network 
        neuralNetwork = NeuralNetwork.createFromFile("desercion_multilayer.nnet");

        // set network input 
        neuralNetwork.setInput(0, 0, 0, 0, 0, 0, 0);

        // calculate network 
        neuralNetwork.calculate();

        // get network output 
        double[] networkOutput = neuralNetwork.getOutput();

        //display
        for (int i = 0; i < networkOutput.length; i++) {
            System.out.println("Salida= " + networkOutput[i]);
        }
    }
}
