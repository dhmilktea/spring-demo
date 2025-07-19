package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChunkLoggingListener implements ChunkListener {

    @Override
    public void beforeChunk(ChunkContext context) {
        long chunkNo = context.getStepContext().getStepExecution().getReadCount() / 10; // CHUNK_SIZE=10
        log.info("START chunk {}", chunkNo);
    }

    @Override
    public void afterChunk(ChunkContext context) {
        long read  = context.getStepContext().getStepExecution().getReadCount();
        long write = context.getStepContext().getStepExecution().getWriteCount();
        log.info("END   chunk {}  (read {}, written {})", (read / 10) - 1, read, write);
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        log.error("ERROR in chunk {}", context.getStepContext().getStepExecution().getReadCount() / 10);
    }
}
