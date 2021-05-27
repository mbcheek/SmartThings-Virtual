
/**
 *  BC Virtual Motion Sensor
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
	definition (name: "BC Virtual Motion Sensor", namespace: "mbcheek", author: "Brandon Cheek", cstHandler: true, vid: "generic-motion-2") {
		capability "Motion Sensor"
		capability "Switch"
        capability "Actuator"
        capability "Sensor"
        capability "Refresh"
        
        command "active"
        command "inactive"
	}


	simulator {
    status "active": "motion:1"
    status "inactive": "motion:0"
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'motion' attribute
	// TODO: handle 'switch' attribute
	def pair = description.split(":")
	createEvent(name: pair[0].trim(), value: pair[1].trim())
}

// handle commands

def active() {
    on()
}

def inactive() {
    off()
}

def on() {
	log.debug "Executing 'on'"
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "motion", value: "active")
	
}

def off() {
	log.debug "Executing 'off'"
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "motion", value: "inactive")
	
}
