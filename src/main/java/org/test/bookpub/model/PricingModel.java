package org.test.bookpub.model;

/**
 * Supported pricing models.
 *
 * @author Ludovic Dewailly
 */
public enum PricingModel {
    /**
     * Indicates a fixed price per room
     */
    FIXED,
    /**
     * Indicates a sliding pricing model whereby the price changes based on the number of guests
     */
    SLIDING
}
