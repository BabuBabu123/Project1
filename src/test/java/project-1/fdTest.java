package project-1;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;
import project-1.fd;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Sample tests for the example component. Remove these and add new tests.
 */
public class fdTest {

	CollectionReaderDescription reader;
	AnalysisEngineDescription analysisEngine;

	@Before
	public void setup() throws ResourceInitializationException, FileNotFoundException {
		File dir = ResourceUtils.getFile(this.getClass().getResource("documents"));
		reader = createReaderDescription(fd.class, fd.PARAM_FILE_DIRECTORY, dir);
		analysisEngine = createEngineDescription(ContentCheckAnalysisEngine.class);
	}
	
	
	@Test
	public void correctContent() throws UIMAException, IOException {
		runPipeline(reader, analysisEngine);
	}
}