import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box-dropdown-wrapper.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-charts/src/vaadin-chart.js';

class DashboardGui extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <vaadin-text-field label="" placeholder="Dashboard" style="flex-grow: 1;"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout>
  <vaadin-button theme="icon" aria-label="Add new">
   <iron-icon icon="lumo:user"></iron-icon>
  </vaadin-button>
  <vaadin-text-field placeholder="Add User">
   <iron-icon icon="lumo:chevron-down" slot="prefix"></iron-icon>
   <vaadin-combo-box-dropdown-wrapper></vaadin-combo-box-dropdown-wrapper>
  </vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;" id="vaadinHorizontalLayout">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-0pct);" id="vaadinVerticalLayout">
   <vaadin-button theme="icon" aria-label="Add new" id="vaadinButton" style="flex-grow: 0;">
    <iron-icon icon="lumo:calendar" id="ironIcon"></iron-icon>
   </vaadin-button>
   <vaadin-button theme="icon" aria-label="Add new" id="vaadinButton1">
    <iron-icon icon="lumo:user" id="ironIcon1"></iron-icon>
   </vaadin-button>
   <vaadin-button theme="icon" aria-label="Add new" id="vaadinButton2">
    <iron-icon icon="lumo:eye" id="ironIcon2"></iron-icon>
   </vaadin-button>
   <vaadin-chart type="area" title="Historic and Estimated Worldwide Population Growth by Region" subtitle="Source: Wikipedia.org" categories="[1750, 1800, 1850, 1900, 1950, 1999, 2050]" stacking="normal" no-legend="" tooltip="">
    <vaadin-chart-series title="Asia" values="[502, 635, 809, 947, 1402, 3634, 5268]" unit="Millions"></vaadin-chart-series>
    <vaadin-chart-series title="Africa" values="[106, 107, 111, 133, 221, 767, 1766]" unit="Millions"></vaadin-chart-series>
    <vaadin-chart-series title="Europe" values="[163, 203, 276, 408, 547, 729, 628]" unit="Millions"></vaadin-chart-series>
    <vaadin-chart-series title="America" values="[18, 31, 54, 156, 339, 818, 1201]" unit="Millions"></vaadin-chart-series>
    <vaadin-chart-series title="Oceania" values="[2, 2, 2, 6, 13, 30, 46]" unit="Millions"></vaadin-chart-series>
   </vaadin-chart>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto;" id="vaadinVerticalLayout1">
   <vaadin-button theme="icon" aria-label="Add new" id="vaadinButton3">
    <iron-icon icon="lumo:edit" id="ironIcon3"></iron-icon>
   </vaadin-button>
   <vaadin-button theme="icon" aria-label="Add new" id="vaadinButton4">
    <iron-icon icon="lumo:checkmark" id="ironIcon4"></iron-icon>
   </vaadin-button>
   <vaadin-button theme="icon" aria-label="Add new">
    <iron-icon icon="lumo:error"></iron-icon>
   </vaadin-button>
   <vaadin-chart type="pie" title="Browser market shares in January, 2018" tooltip="">
    <vaadin-chart-series title="Brands" values="[[&quot;Chrome&quot;,61.41],[&quot;Internet Explorer&quot;,11.84],[&quot;Firefox&quot;,10.85],[&quot;Edge&quot;,4.67],[&quot;Safari&quot;,4.18],[&quot;Sogou Explorer&quot;,1.64],[&quot;Opera&quot;,1.6],[&quot;QQ&quot;,1.2],[&quot;Other&quot;,2.61]]"></vaadin-chart-series>
   </vaadin-chart>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'dashboard-gui';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DashboardGui.is, DashboardGui);
