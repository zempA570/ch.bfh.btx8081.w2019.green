import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class InfoboxStart extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="margin" style="align-self: stretch; justify-content: space-between;">
  <vaadin-button>
   &lt; Back
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new">
   <iron-icon icon="lumo:plus"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" style="align-self: stretch; flex-shrink: 1; flex-grow: 0;">
  <h4 style="flex-grow: 0;">Wichtige Telefonnummer</h4>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-shrink: 1; flex-grow: 0; align-self: stretch;">
  <vaadin-vertical-layout theme="spacing" style="flex-shrink: 1; flex-grow: 0; align-self: stretch;">
   <h4 style="flex-grow: 0;"></h4>
  </vaadin-vertical-layout>
  <h4 style="flex-grow: 0;">Wichtige Adressen</h4>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
  <vaadin-button theme="primary" style="align-self: stretch;">
    Primary 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'infobox-start';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InfoboxStart.is, InfoboxStart);
