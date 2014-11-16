package distantshoresmedia.org.keyboard;

/**
 * Created by Fechner on 11/15/14.
 */
public interface OnKeyboardActionListener {

    /**
     * Called when the user presses a key. This is sent before the
     * {@link #onKey} is called. For keys that repeat, this is only
     * called once.
     *
     * @param primaryCode
     *            the unicode of the key being pressed. If the touch is
     *            not on a valid key, the value will be zero.
     */
    void onPress(int primaryCode);

    /**
     * Called when the user releases a key. This is sent after the
     * {@link #onKey} is called. For keys that repeat, this is only
     * called once.
     *
     * @param primaryCode
     *            the code of the key that was released
     */
    void onRelease(int primaryCode);

    /**
     * Send a key press to the listener.
     *
     * @param primaryCode
     *            this is the key that was pressed
     * @param keyCodes
     *            the codes for all the possible alternative keys with
     *            the primary code being the first. If the primary key
     *            code is a single character such as an alphabet or
     *            number or symbol, the alternatives will include other
     *            characters that may be on the same key or adjacent
     *            keys. These codes are useful to correct for
     *            accidental presses of a key adjacent to the intended
     *            key.
     * @param x
     *            x-coordinate pixel of touched event. If onKey is not called by onTouchEvent,
     *            the value should be NOT_A_TOUCH_COORDINATE.
     * @param y
     *            y-coordinate pixel of touched event. If onKey is not called by onTouchEvent,
     *            the value should be NOT_A_TOUCH_COORDINATE.
     */
    void onKey(int primaryCode, int[] keyCodes, int x, int y);

    /**
     * Sends a sequence of characters to the listener.
     *
     * @param text
     *            the sequence of characters to be displayed.
     */
    void onText(CharSequence text);

    /**
     * Called when user released a finger outside any key.
     */
    void onCancel();

    /**
     * Called when the user quickly moves the finger from right to
     * left.
     */
    boolean swipeLeft();

    /**
     * Called when the user quickly moves the finger from left to
     * right.
     */
    boolean swipeRight();

    /**
     * Called when the user quickly moves the finger from up to down.
     */
    boolean swipeDown();

    /**
     * Called when the user quickly moves the finger from down to up.
     */
    boolean swipeUp();
}