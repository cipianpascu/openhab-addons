/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.rfxcom.internal.messages;

import static org.openhab.binding.rfxcom.internal.RFXComBindingConstants.*;
import static org.openhab.binding.rfxcom.internal.messages.RFXComBaseMessage.PacketType.FAN_LUCCI_DC;
import static org.openhab.binding.rfxcom.internal.messages.RFXComFanMessage.SubType.LUCCI_AIR_DC;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.library.types.StringType;
import org.openhab.core.library.types.UpDownType;
import org.openhab.core.types.State;
import org.openhab.core.types.UnDefType;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden - Initial contribution
 */
@NonNullByDefault
public class RFXComFanLucciAirDcMessageTest {

    @Test
    public void testUp() throws RFXComException {
        testCommand(CHANNEL_FAN_SPEED, UpDownType.UP, UnDefType.UNDEF, UpDownType.UP, StringType.valueOf("UP"));
    }

    @Test
    public void testDown() throws RFXComException {
        testCommand(CHANNEL_FAN_SPEED, UpDownType.DOWN, UnDefType.UNDEF, UpDownType.DOWN, StringType.valueOf("DOWN"));
    }

    @Test
    public void testCommandString() throws RFXComException {
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("POWER"), UnDefType.UNDEF, null,
                StringType.valueOf("POWER"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("UP"), UnDefType.UNDEF, UpDownType.UP,
                StringType.valueOf("UP"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("DOWN"), UnDefType.UNDEF, UpDownType.DOWN,
                StringType.valueOf("DOWN"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("LIGHT"), OnOffType.ON, null,
                StringType.valueOf("LIGHT"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("REVERSE"), UnDefType.UNDEF, null,
                StringType.valueOf("REVERSE"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("NATURAL_FLOW"), UnDefType.UNDEF, null,
                StringType.valueOf("NATURAL_FLOW"));
        testCommand(CHANNEL_COMMAND_STRING, StringType.valueOf("PAIR"), UnDefType.UNDEF, null,
                StringType.valueOf("PAIR"));
    }

    private void testCommand(String channel, State inputValue, State expectedLightCommand,
            @Nullable State expectedFanSpeed, State expectedCommandString) throws RFXComException {
        RFXComFanMessageTest.testCommand(LUCCI_AIR_DC, channel, inputValue, null, expectedLightCommand,
                expectedFanSpeed, expectedCommandString, FAN_LUCCI_DC);
    }
}
