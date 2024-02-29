package cn.nukkit.network.protocol.types;

import cn.nukkit.math.BlockVector3;
import lombok.Data;

@Data
public class BlockChangeEntry {

    private BlockVector3 blockPos;
    private long runtimeID;
    private int updateFlags;
    private long messageEntityID;
    private MessageType messageType;

    public BlockChangeEntry(BlockVector3 blockPos, long runtimeID, int updateFlags, long messageEntityID, MessageType messageType) {
        this.blockPos = blockPos;
        this.runtimeID = runtimeID;
        this.updateFlags = updateFlags;
        this.messageEntityID = messageEntityID;
        this.messageType = messageType;
    }

    public enum MessageType {
        NONE,
        CREATE,
        DESTROY
    }
}