package com.daasuu.gpuv.composer;

import android.media.MediaMetadataRetriever;

public class MediaDataRetrieverWrapper implements AutoCloseable {

    private MediaMetadataRetriever mediaMetadataRetriever;

    public MediaDataRetrieverWrapper()
    {
        mediaMetadataRetriever = new MediaMetadataRetriever();
    }

    public MediaDataRetrieverWrapper(String path)
    {
        mediaMetadataRetriever = new MediaMetadataRetriever();
        setDataSource(path);
    }

    public void setDataSource(String path) throws IllegalArgumentException
    {
        mediaMetadataRetriever.setDataSource(path);
    }

    public String extractMetadata(int keyCode)
    {
        return mediaMetadataRetriever.extractMetadata(keyCode);
    }

    public Integer extractMetadataInt(int keyCode)
    {
        String metadataValue = extractMetadata(keyCode);
        return Integer.valueOf(metadataValue);
    }

    public Float extractMetadataFloat(int keyCode)
    {
        String metadataValue = extractMetadata(keyCode);
        return Float.valueOf(metadataValue);
    }

    @Override
    public void close() throws Exception {
        mediaMetadataRetriever.release();
    }
}
