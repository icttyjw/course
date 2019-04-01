package edu.ictt.course.block;

import cn.hutool.crypto.digest.DigestUtil;
import edu.ictt.course.common.SHA256;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;


public class Block {


	//区块头
	 @JSONField(ordinal=1)
	private BlockHeader blockHeader;

	//区块体
	 @JSONField(ordinal=2)
	private  BlockBody blockBody;

	//区块哈希
	@JSONField(ordinal=3)
	private String blockHash;

	public Block(){}

	public Block(BlockHeader blockHeader, BlockBody blockBody){
		this.blockHeader = blockHeader;
		this.blockBody = blockBody;
	}

	public BlockHeader getBlockHeader() {
		return blockHeader;
	}

	public void setBlockHeader(BlockHeader blockHeader) {
		this.blockHeader = blockHeader;
	}

	public BlockBody getBlockBody() {
		return blockBody;
	}

	public void setBlockBody(BlockBody blockBody) {
		this.blockBody = blockBody;
	}

	public String getBlockHash() {

		return blockHash;
	}

	public void setBlockHash(String blockHash) {

		this.blockHash = blockHash;
	}

	@Override
	public String toString(){
		return "Block{" +
                "blockHeader=" + blockHeader +
                ", blockBody=" + blockBody +
                ", hash='" + blockHash + '\'' +
                '}';
	}
	/**
	 * 根据该区块所有属性计算sha256
	 * @return
	 * sha256hex
	 */
	private String calculateHash() {
		return SHA256.sha256(
				blockHeader.toString() + blockBody.toString()
		);
	}

}
