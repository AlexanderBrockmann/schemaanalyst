package org.schemaanalyst._deprecated.datageneration;

public abstract class DataGenerator<G> {

    public abstract TestSuite<G> generate();
}