import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div className="topnav">
            <a className="active" href="/">Wizyty</a>
            <a href="/patientSearch">Dodaj wizytę</a>

          </div>
        )
    }
}

export default HeaderComponent
