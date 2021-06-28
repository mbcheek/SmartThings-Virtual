/**
 *  BC Virtual Contact Sensor
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
	definition (name: "BC Virtual Contact Sensor", namespace: "mbcheek", author: "Brandon Cheek", cstHandler: true, vid: "generic-contact-2") {
        capability "Contact Sensor"
	    capability "Switch"
        capability "Actuator"
        capability "Sensor"
        capability "Refresh"
        
        command "open"
        command "close"
	}


	simulator {
    status "open": "contact:open"
    status "closed": "contact:closed"
		// TODO: define status and reply messages here
	}

	tiles {
		standardTile("contact", "device.contact", width: 2, height: 2) {
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
	}
    
	main "contact"
	details "contact"
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

def open() {
    log.debug "open()"
    on()
}

def close() {
    log.debug "close()"
    off()
}

def on() {
	log.debug "Executing 'on'"
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "contact", value: "open")
	
}

def off() {
	log.debug "Executing 'off'"
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "contact", value: "closed")
	
}