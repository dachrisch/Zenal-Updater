package de.pentasys.zenal;

import static de.pentasys.zenal.builder.DateTimeGenerator.from;
import static de.pentasys.zenal.builder.ZenalEntryCreator.datetime;
import static de.pentasys.zenal.builder.ZenalEntryCreator.within;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.pentasys.zenal.builder.Category;
import de.pentasys.zenal.builder.Project;

public class FloatingApiZenalEntryTest {

    @Test
    public void testCreateZenalEntryList() throws Exception {

        final ZenalEntryList zenalEntryList = within(Project.MEDIASATURN)
                .drivingTo("Anfahrt", from(datetime(2011, 5, 10, 7, 50)).till(9, 20))
                .working("Lasttest", from(datetime(2011, 5, 10, 9, 20)).till(17, 20))
                .drivingReturn("Rückfahrt", from(datetime(2011, 5, 10, 17, 50)).till(19, 20)).list();

        assertThat(zenalEntryList.size(), is(3));
        assertThat(zenalEntryList.get(0), is(new ZenalEntry(Project.MEDIASATURN, datetime(2011, 5, 10, 7, 50),
                datetime(2011, 5, 10, 9, 20), "Anfahrt", Category.TRAVEL_START)));
        assertThat(zenalEntryList.get(1), is(new ZenalEntry(Project.MEDIASATURN, datetime(2011, 5, 10, 9, 20),
                datetime(2011, 5, 10, 17, 20), "Lasttest", Category.PROJECT)));
        assertThat(zenalEntryList.get(2), is(new ZenalEntry(Project.MEDIASATURN, datetime(2011, 5, 10, 17, 50),
                datetime(2011, 5, 10, 19, 20), "Rückfahrt", Category.TRAVEL_END)));

    }

}
