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
public class NN_Cochej {

    public static void main(String[] args) {
        // create new perceptron network 
        NeuralNetwork neuralNetwork = new MultiLayerPerceptron(2,2, 2);
        // create training set 
        DataSet trainingSet = new DataSet(2, 2);

        trainingSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{0, 1}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{0, -1}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{0.5, 1}, new double[]{-1, 1}));
        trainingSet.add(new DataSetRow(new double[]{0.5, -1}, new double[]{1, 1}));
        trainingSet.add(new DataSetRow(new double[]{0.5, 0}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{1, 1}, new double[]{0, -1}));
        trainingSet.add(new DataSetRow(new double[]{1, -1}, new double[]{0, -1}));
        trainingSet.add(new DataSetRow(new double[]{1, 0}, new double[]{0, -1}));
        trainingSet.add(new DataSetRow(new double[]{-1, 0}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{-1, -1}, new double[]{0, 1}));
        trainingSet.add(new DataSetRow(new double[]{-1, 1}, new double[]{0, 1}));

        // learn the training set 
        neuralNetwork.learn(trainingSet);

        // save the trained network into file 
        neuralNetwork.save("cochej_multilayer.nnet");

        // load the saved network 
        neuralNetwork = NeuralNetwork.createFromFile("cochej_multilayer.nnet");

        // set network input 
        neuralNetwork.setInput(0, 0);

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
