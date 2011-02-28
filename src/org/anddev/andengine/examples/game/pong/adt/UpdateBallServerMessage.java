package org.anddev.andengine.examples.game.pong.adt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.anddev.andengine.examples.game.pong.util.constants.PongConstants;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.BaseServerMessage;

/**
 * @author Nicolas Gramlich
 * @since 19:48:32 - 28.02.2011
 */
public class UpdateBallServerMessage extends BaseServerMessage implements PongConstants {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	public final float mX;
	public final float mY;

	// ===========================================================
	// Constructors
	// ===========================================================

	public UpdateBallServerMessage(final float pX, final float pY) {
		this.mX = pX;
		this.mY = pY;
	}

	public UpdateBallServerMessage(final DataInputStream pDataInputStream) throws IOException {
		this.mX = pDataInputStream.readFloat();
		this.mY = pDataInputStream.readFloat();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public short getFlag() {
		return FLAG_MESSAGE_SERVER_UPDATE_BALL;
	}

	@Override
	protected void onWriteTransmissionData(final DataOutputStream pDataOutputStream) throws IOException {
		pDataOutputStream.writeFloat(this.mX);
		pDataOutputStream.writeFloat(this.mY);
	}

	@Override
	protected void onAppendTransmissionDataForToString(final StringBuilder pStringBuilder) {

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}