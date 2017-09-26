package com.boris.decompressor.Service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

/**
 * Created by boris on 19.09.17.
 * Test class.
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class FileHandlerServiceTest {



    @Mock
    private FileDecompressor fileDecompressor;


    private String extensionZip = "zip";
    private String extensionBZip2 = "bzip2";
    private String extensionGZip = "gzip";
    private String extensionRar = "rar";



    @Test
    public void processFileTest() throws Exception {

        when(fileDecompressor.canDecompress(extensionZip)).thenReturn(true);
        when(fileDecompressor.canDecompress(extensionGZip)).thenReturn(true);
        when(fileDecompressor.canDecompress(extensionBZip2)).thenReturn(true);
        when(fileDecompressor.canDecompress(extensionRar)).thenReturn(false);

        assertEquals(fileDecompressor.canDecompress(extensionZip), true);
        assertEquals(fileDecompressor.canDecompress(extensionBZip2), true);
        assertEquals(fileDecompressor.canDecompress(extensionGZip), true);
        assertEquals(fileDecompressor.canDecompress(extensionRar), false);


        verify(fileDecompressor, atLeastOnce()).canDecompress(extensionRar);
        verify(fileDecompressor, atLeastOnce()).canDecompress(extensionZip);
        verify(fileDecompressor, atLeastOnce()).canDecompress(extensionBZip2);
        verify(fileDecompressor, atLeastOnce()).canDecompress(extensionGZip);






    }

}