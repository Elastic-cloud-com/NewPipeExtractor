package org.schabi.newpipe.extractor.services.peertube;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.schabi.newpipe.extractor.ExtractorAsserts.assertEmpty;
import static org.schabi.newpipe.extractor.ExtractorAsserts.assertIsSecureUrl;
import static org.schabi.newpipe.extractor.ServiceList.PeerTube;
import static org.schabi.newpipe.extractor.services.DefaultTests.defaultTestGetPageInNewExtractor;
import static org.schabi.newpipe.extractor.services.DefaultTests.defaultTestMoreItems;
import static org.schabi.newpipe.extractor.services.DefaultTests.defaultTestRelatedItems;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.schabi.newpipe.DownloaderTestImpl;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.BaseChannelExtractorTest;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeChannelExtractor;

/**
 * Test for {@link PeertubeChannelExtractor}
 */
public class PeertubeChannelExtractorTest {
    public static class KDE implements BaseChannelExtractorTest {
        private static PeertubeChannelExtractor extractor;

        @BeforeClass
        public static void setUp() throws Exception {
            NewPipe.init(DownloaderTestImpl.getInstance());
            // setting instance might break test when running in parallel
            PeerTube.setInstance(new PeertubeInstance("https://peertube.mastodon.host", "PeerTube on Mastodon.host"));
            extractor = (PeertubeChannelExtractor) PeerTube
                    .getChannelExtractor("https://peertube.mastodon.host/api/v1/accounts/kde");
            extractor.fetchPage();
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Extractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testServiceId() {
            assertEquals(PeerTube.getServiceId(), extractor.getServiceId());
        }

        @Test
        public void testName() throws ParsingException {
            assertEquals("The KDE Community", extractor.getName());
        }

        @Test
        public void testId() throws ParsingException {
            assertEquals("kde", extractor.getId());
        }

        @Test
        public void testUrl() throws ParsingException {
            assertEquals("https://peertube.mastodon.host/api/v1/accounts/kde", extractor.getUrl());
        }

        @Test
        public void testOriginalUrl() throws ParsingException {
            assertEquals("https://peertube.mastodon.host/accounts/kde", extractor.getOriginalUrl());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ListExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testRelatedItems() throws Exception {
            defaultTestRelatedItems(extractor, PeerTube.getServiceId());
        }

        @Test
        public void testMoreRelatedItems() throws Exception {
            defaultTestMoreItems(extractor, PeerTube.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ChannelExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testDescription() throws ParsingException {
            assertNotNull(extractor.getDescription());
        }

        @Test
        public void testAvatarUrl() throws ParsingException {
            assertIsSecureUrl(extractor.getAvatarUrl());
        }

        @Ignore
        @Test
        public void testBannerUrl() throws ParsingException {
            assertIsSecureUrl(extractor.getBannerUrl());
        }

        @Test
        public void testFeedUrl() throws ParsingException {
            assertEmpty(extractor.getFeedUrl());
        }

        @Test
        public void testSubscriberCount() throws ParsingException {
            assertTrue("Wrong subscriber count", extractor.getSubscriberCount() >= 5);
        }
    }

    public static class Booteille implements BaseChannelExtractorTest {
        private static PeertubeChannelExtractor extractor;

        @BeforeClass
        public static void setUp() throws Exception {
            NewPipe.init(DownloaderTestImpl.getInstance());
            // setting instance might break test when running in parallel
            PeerTube.setInstance(new PeertubeInstance("https://peertube.mastodon.host", "PeerTube on Mastodon.host"));
            extractor = (PeertubeChannelExtractor) PeerTube
                    .getChannelExtractor("https://peertube.mastodon.host/accounts/booteille");
            extractor.fetchPage();
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Additional Testing
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testGetPageInNewExtractor() throws Exception {
            final ChannelExtractor newExtractor = PeerTube.getChannelExtractor(extractor.getUrl());
            defaultTestGetPageInNewExtractor(extractor, newExtractor, PeerTube.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Extractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testServiceId() {
            assertEquals(PeerTube.getServiceId(), extractor.getServiceId());
        }

        @Test
        public void testName() throws ParsingException {
            assertEquals("booteille", extractor.getName());
        }

        @Test
        public void testId() throws ParsingException {
            assertEquals("booteille", extractor.getId());
        }

        @Test
        public void testUrl() throws ParsingException {
            assertEquals("https://peertube.mastodon.host/api/v1/accounts/booteille", extractor.getUrl());
        }

        @Test
        public void testOriginalUrl() throws ParsingException {
            assertEquals("https://peertube.mastodon.host/accounts/booteille", extractor.getOriginalUrl());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ListExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testRelatedItems() throws Exception {
            defaultTestRelatedItems(extractor, PeerTube.getServiceId());
        }

        @Test
        public void testMoreRelatedItems() throws Exception {
            defaultTestMoreItems(extractor, PeerTube.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ChannelExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testDescription() throws ParsingException {
            assertNotNull(extractor.getDescription());
        }

        @Test
        public void testAvatarUrl() throws ParsingException {
            assertIsSecureUrl(extractor.getAvatarUrl());
        }

        @Ignore
        @Test
        public void testBannerUrl() throws ParsingException {
            assertIsSecureUrl(extractor.getBannerUrl());
        }

        @Test
        public void testFeedUrl() throws ParsingException {
            assertEmpty(extractor.getFeedUrl());
        }

        @Test
        public void testSubscriberCount() throws ParsingException {
            assertTrue("Wrong subscriber count", extractor.getSubscriberCount() >= 1);
        }
    }
}
