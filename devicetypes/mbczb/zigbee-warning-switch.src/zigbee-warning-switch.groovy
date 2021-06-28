/**
 *  Zigbee Warning Switch
 *
 *  Copyright 2021 Brandon Cheek
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "Zigbee Warning Switch", namespace: "mbcZB", author: "Brandon Cheek", cstHandler: true) {
		capability "Firmware Update"
		capability "Switch"
        capability "Actuator"
        command "Blink"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'availableVersion' attribute
	// TODO: handle 'currentVersion' attribute
	// TODO: handle 'lastUpdateTime' attribute
	// TODO: handle 'lastUpdateStatus' attribute
	// TODO: handle 'lastUpdateStatusReason' attribute
	// TODO: handle 'state' attribute
	// TODO: handle 'switch' attribute

}

// handle commands
def checkForFirmwareUpdate() {
	log.debug "Executing 'checkForFirmwareUpdate'"
	// TODO: handle 'checkForFirmwareUpdate' command
}

def updateFirmware() {
	log.debug "Executing 'updateFirmware'"
	// TODO: handle 'updateFirmware' command
}

def on() {
		delayBetween ([
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
                        ], 1000)
    log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def blink() {
	delayBetween ([
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
    	delayBetween ([	zigbee.on(),
        		zigbee.off()], 1000),
                        ], 1000)
}