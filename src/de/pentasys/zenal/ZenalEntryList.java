package de.pentasys.zenal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ZenalEntryList extends AbstractList<ZenalEntry> {

    private final List<ZenalEntry> entries = new ArrayList<ZenalEntry>();

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean add(final ZenalEntry zenalEntry) {
        return entries.add(zenalEntry);
    }

    @Override
    public ZenalEntry get(final int position) {
        return entries.get(position);
    }

}
