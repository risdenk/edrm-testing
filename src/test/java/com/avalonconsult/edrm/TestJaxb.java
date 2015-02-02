package com.avalonconsult.edrm;

import com.avalonconsult.edrm.generated.BatchType;
import com.avalonconsult.edrm.generated.DocumentType;
import com.avalonconsult.edrm.generated.DocumentsType;
import com.avalonconsult.edrm.generated.Root;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by risdenk on 2/2/15.
 */
public class TestJaxb {
  @Test
  public void testName() throws Exception {
    Root root = new Root();
    root.setCaseId("test");
    BatchType batchType = new BatchType();
    batchType.setName("test");
    DocumentsType documentsType = new DocumentsType();
    DocumentType documentType = new DocumentType();
    documentType.setDocID("id1");
    documentType.setDocType("doctype1");
    documentsType.getDocument().add(documentType);
    batchType.setDocuments(documentsType);
    root.getBatch().add(batchType);

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(root, System.out);

    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
