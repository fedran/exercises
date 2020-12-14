package org.fedran.stepic;

public class AsciiCharSequence implements CharSequence {
    private final byte[] value;

    public AsciiCharSequence(byte[] bytes) {
        this.value = bytes;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    @Override
    public char charAt(final int index) {
        return (char) this.value[index];
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        final byte[] bytes = new byte[end - start];
        if (bytes.length >= 0) {
            System.arraycopy(this.value, start, bytes, 0, bytes.length);
        }
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (byte b : this.value) {
            stringBuilder.append((char) b);
        }
        return stringBuilder.toString();
    }
}
