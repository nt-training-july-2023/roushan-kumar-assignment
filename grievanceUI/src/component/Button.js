import React from 'react'

function Button({
    id,
    name,
    className,
    onClick,
    type,
    value,
    hidden,
    disabled,
}) {
    return (
        <>
            <button
                id={id}
                name={name}
                className={className}
                onClick={onClick}
                type={type}
                value={value}
                hidden = {hidden}
                disabled = {disabled}
            >
                {name}
            </button>
        </>
    )
}

export default Button